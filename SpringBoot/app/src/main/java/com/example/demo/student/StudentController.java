package com.example.demo.student;

import java.time.Month;
import java.util.*;
import java.time.LocalDate;    


import com.example.demo.student.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


 

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService s){
        //We can use Dependency Injection
        this.studentService = s;

    }
    
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudent();
    }
}
