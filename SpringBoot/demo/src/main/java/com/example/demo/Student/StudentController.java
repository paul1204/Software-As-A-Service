package com.example.demo.Student;

import java.time.Month;
import java.util.*;
import java.time.LocalDate;    


import com.example.demo.Student.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;


 

@RestController
@RequestMapping(path = "student")
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

    //@Request Body-
    //The input is a JSON string
    //Map JSON into Student Object
    @PostMapping
    public void registerNewStudent(@RequestBody Student s){
        studentService.addNewStudent(s);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
       studentService.updateStudent(id, name, email);
    }


}
