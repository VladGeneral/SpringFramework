package com.example.springbootdatamongodb.service;

import com.example.springbootdatamongodb.entity.Student;
import com.example.springbootdatamongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Student getStudentById(String id) {
        Optional<Student> result = studentRepository.findById(id);
        Student student;
        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been delete";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }
}
