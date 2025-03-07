package dev.well.springboot_rest_api.controller;

import dev.well.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent () {
        Student student = new Student(1, "Ruben", "Rocha");

        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Ruben").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents (){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ruben","Rocha"));
        students.add(new Student(2,"Afonso","Rocha"));

        return ResponseEntity.ok(students);
    }

    //Spring Boot Rest Api with Path Variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){
         Student student = new Student(studentId, "Ruben", "Rocha");
         return ResponseEntity.ok(student);
    }

    //Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Ruben&lastName=Rocha
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return  ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP POST Request - creating new resource
    //@PostMapping and @RequestBody converts JSon to java object
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP DELETE Request - delete existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent (@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}