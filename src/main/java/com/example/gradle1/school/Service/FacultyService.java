package com.example.gradle1.school.Service;

import com.example.gradle1.school.Model.Faculty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    public long countFaculty = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(countFaculty++);
        faculties.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }
    public Faculty editFaculty(Faculty faculty) {
        if (!faculties.containsKey(faculty)){
            return null;
        }
        faculties.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }


    public List<Faculty> filterFaculty(String color){
        return new ArrayList<>(faculties.values()).stream().filter(faculty ->faculty.getColor().equals(color) ).toList();
        //.orElseThrow(() -> new EmployeeNotFoundException("не найден"));
    }
}
