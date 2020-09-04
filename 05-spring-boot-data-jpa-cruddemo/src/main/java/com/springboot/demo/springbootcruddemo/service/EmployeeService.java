package com.springboot.demo.springbootcruddemo.service;

import com.springboot.demo.springbootcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
