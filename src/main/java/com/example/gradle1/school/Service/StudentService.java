package com.example.gradle1.school.Service;

import com.example.gradle1.school.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private final HashMap<Long, Student> students= new HashMap<>();
    private long countStudents = 0;

    public Student createStudent(Student student){
        student.setId(countStudents++);
        students.put(countStudents,student);
        return student;
    }
    public Student findStudent(Long id) {
        return students.get(id);
    }
    public Student editStudent(Student student) {
        if (!students.containsKey(student)){
            return null;
        }
       students.put(student.getId(),student);
       return student;
    }
    public Student deleteStudent(Long id) {
        return students.remove(id);
    }


    public List<Student> filterStudents(int age){
        return new ArrayList<>(students.values()).stream().filter(student ->student.getAge() == age ).toList();
        //.orElseThrow(() -> new EmployeeNotFoundException("не найден"));
    }
}
