package com.example.demo;

import java.time.Month;
import java.util.*;
import java.time.LocalDate;


import com.example.demo.Student.Student;
import com.example.demo.Student.StudentController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceApplication.class, args);
	}

}