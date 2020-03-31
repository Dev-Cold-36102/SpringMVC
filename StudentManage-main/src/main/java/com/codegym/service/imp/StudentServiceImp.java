package com.codegym.service.imp;

import com.codegym.model.Student;
import com.codegym.repositories.StudentRepository;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) this.studentRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
