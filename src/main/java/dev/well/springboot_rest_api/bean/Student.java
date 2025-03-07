package dev.well.springboot_rest_api.bean;

public class Student {
    private int id;
    private String firstName;
    private String lastName;


    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){return firstName;}

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
