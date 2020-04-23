package com.codegym.service;
import com.codegym.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student save(Student student);
}
