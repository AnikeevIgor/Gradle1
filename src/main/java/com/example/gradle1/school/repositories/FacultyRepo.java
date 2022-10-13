package com.example.gradle1.school.repositories;

import com.example.gradle1.school.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty,Long> {
}
