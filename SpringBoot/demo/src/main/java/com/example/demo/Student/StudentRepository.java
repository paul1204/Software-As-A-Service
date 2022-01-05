package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    //Lets find a user by email

    //Select * from student where email = email

    //jbql
    //@Query("SELECT s FROM student WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);


}
