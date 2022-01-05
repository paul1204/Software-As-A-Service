package com.example.demo.Student;

import java.time.Month;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;  
import org.springframework.beans.factory.annotation.Autowired;

//Class that has to be a Spring Beam?
@Service
public class StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository repo){
        this.studentRepo = repo;
    }

    public List<Student> getStudent(){
        return studentRepo.findAll();
	}

    public void addNewStudent(Student s) {
        Optional<Student> studentEmail = studentRepo.findStudentByEmail(s.getEmail());
        if(studentEmail.isPresent()){throw new IllegalStateException("email taken");}
        studentRepo.save(s);
        System.out.println(s);
    }

    public void deleteStudent(Long id) {
        boolean trigger = studentRepo.existsById(id);

        if(!trigger){
            throw new IllegalStateException(
                    "Student with ID " + id + "does not exists"
            );
        }
        studentRepo.deleteById(id);
    }
}