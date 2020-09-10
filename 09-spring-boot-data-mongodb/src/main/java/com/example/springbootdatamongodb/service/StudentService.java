package com.example.springbootdatamongodb.service;

import com.example.springbootdatamongodb.entity.Student;
import com.example.springbootdatamongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//        return studentRepository.findByName(name);
        return studentRepository.getByName(name);
    }

    public List<Student> getStudentsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getStudentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        //or Sort.Direction.ASC,"name", "email", "etc"
        return studentRepository.findAll(sort);
    }

    public List<Student> getByDepartmentName(String name) {
        return studentRepository.findByDepartmentDepartmentName(name);
    }

    public List<Student> getBySubjectName(String name) {
        return studentRepository.findBySubjectsSubjectName(name);
    }

    public List<Student> getEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String id) {
        return studentRepository.findByDepartmentId(id);
    }
}
