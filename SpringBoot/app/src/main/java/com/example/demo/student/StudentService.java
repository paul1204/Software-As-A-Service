package com.example.demo.student;

import java.time.Month;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;  


//Class that has to be a Spring Beam?
@Service
public class StudentService {
    public List<Student> getStudent(){
		return List.of(
			new Student(
				1L,
				"Mariam",
				"something@email.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	}
}
