package com.example.demo.student;
import java.time.LocalDate;    



public class Student{
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;





    public Student(){

    }

    public Student(Long i, String n, String e, LocalDate d,Integer a){
        this.id = i;
        this.name = n;
        this.email = e;
        this.dob = d;
        this.age = a;
    }


    public Student(String n, String e, Integer a){
        this.name = n;
        this.email = e;
        //this.dob = d;
        this.age = a;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setEmail(String e){
        this.email = e;
    }

    public void setAge(Integer a){
        this.age = a;
    }

    public void setDob(LocalDate d){
            this.dob = d;
    }

    public LocalDate getDob(){
            return this.dob;
    }


    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public Integer getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return "Student{" + 
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob + '}' + 
                ", age=" + age + '}';

    }


}

