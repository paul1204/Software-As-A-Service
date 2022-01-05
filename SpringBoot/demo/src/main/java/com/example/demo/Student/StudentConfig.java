package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner clr(StudentRepository repo){
        return args -> {
            Student mariam = new Student("Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
            Student bill = new Student("Bill", "bill@gmail.com", LocalDate.of(2004, Month.JANUARY, 5));

            repo.saveAll(
                    List.of(mariam, bill)
            );
        };
    }

}
