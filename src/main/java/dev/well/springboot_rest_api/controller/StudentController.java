package dev.well.springboot_rest_api.controller;

import dev.well.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent () {
        return new Student(1, "Ruben", "Rocha");
    }

    @GetMapping("/students")
    public List<Student> getStudents (){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ruben","Rocha"));
        students.add(new Student(2,"Afonso","Rocha"));
        return students;
    }

    //Spring Boot Rest Api with Path Variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Ruben", "Rocha");
    }

    //Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Ruben&lastName=Rocha
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return  new Student(id, firstName, lastName);
    }

    //Spring boot REST API that handles HTTP POST Request - creating new resource
    //@PostMapping and @RequestBody converts JSon to java object
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring boot REST API that handles HTTP DELETE Request - delete existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent (@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully!";
    }

}