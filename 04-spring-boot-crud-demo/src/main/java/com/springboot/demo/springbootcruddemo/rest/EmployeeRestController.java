package com.springboot.demo.springbootcruddemo.rest;

import com.springboot.demo.springbootcruddemo.dao.EmployeeDAO;
import com.springboot.demo.springbootcruddemo.entity.Employee;
import com.springboot.demo.springbootcruddemo.service.EmployeeService;
import com.springboot.demo.springbootcruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }
}
