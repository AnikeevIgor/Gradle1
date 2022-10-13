package com.example.gradle1.school.repositories;


import com.example.gradle1.school.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
