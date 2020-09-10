package com.example.springbootdatamongodb.service;

import com.example.springbootdatamongodb.entity.Student;
import com.example.springbootdatamongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Transactional
    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }
}
