package com.example.gradle1.school.Controllr;


import com.example.gradle1.school.Model.Student;
import com.example.gradle1.school.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id){
        Student student = studentService.findStudent(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student student1 = studentService.editStudent(student);
        if(student1==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("{age}")
    public List<Student> filterStudents(@PathVariable int age){
        return studentService.filterStudents(age);
    }
}
