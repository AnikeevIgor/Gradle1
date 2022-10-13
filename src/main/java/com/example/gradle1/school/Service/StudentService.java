package com.example.gradle1.school.Service;

import com.example.gradle1.school.Model.Student;
import com.example.gradle1.school.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student){
       return studentRepo.save(student);
    }
    public Student findStudent(Long id) {
        return studentRepo.findById(id).get();
    }
    public Student editStudent(Student student) {
       return studentRepo.save(student);
    }
    public void deleteStudent(Long id) {
         studentRepo.deleteById(id);
    }

    public Collection<Student> getAllStudents(){
        return studentRepo.findAll();
    }

}
