package com.example.springbootdatamongodb.controller;

import com.example.springbootdatamongodb.entity.Student;
import com.example.springbootdatamongodb.entity.Subject;
import com.example.springbootdatamongodb.repository.DepartmentRepository;
import com.example.springbootdatamongodb.repository.SubjectRepository;
import com.example.springbootdatamongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;
//
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        if (student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if (student.getSubjects() != null && student.getSubjects().size() > 0 ){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String updateStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name){
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/studentsByNameAndEmail")
    public List<Student> studentsByNameAndEmail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentsByNameAndEmail(name, email);
    }

    @GetMapping("/studentsByNameOrEmail")
    public List<Student> studentsByNameOrEmail(@RequestParam String name,
                                               @RequestParam String email){
        return studentService.getStudentsByNameOrEmail(name, email);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo,
                                               @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo,pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> getAllWithSorting(){
        return studentService.getAllWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> getByDepartmentName(@RequestParam String name){
        return studentService.getByDepartmentName(name);
    }

    @GetMapping("/bySubjectName")
    public List<Student> getBySubjectName(@RequestParam String name){
        return studentService.getBySubjectName(name);
    }

    @GetMapping("/emailLike")
    public List<Student> getEmailLike(@RequestParam String email){
        return studentService.getEmailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name){
        return studentService.nameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String id){
        return studentService.byDepartmentId(id);
    }
}
