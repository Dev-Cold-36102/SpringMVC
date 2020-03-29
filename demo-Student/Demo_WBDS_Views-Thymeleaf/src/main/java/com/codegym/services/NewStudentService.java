package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewStudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
//
//    public NewStudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> getAllStudents(String startWithText) {
        return (List<Student>) this.studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
