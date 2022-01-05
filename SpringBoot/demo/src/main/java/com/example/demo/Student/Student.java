package com.example.demo.Student;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;


@Entity
@Table
public class Student{

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )


    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient
    private Integer age;

    public Student(){
    }

    public Student(Long i, String n, String e, LocalDate d){
        this.id = i;
        this.name = n;
        this.email = e;
        this.dob = d;
        //this.age = a;
    }


    public Student(String n, String e,  LocalDate d){
        this.name = n;
        this.email = e;
        this.dob = d;
        //this.age = a;
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
        return Period.between(this.dob, LocalDate.now()).getYears();
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

