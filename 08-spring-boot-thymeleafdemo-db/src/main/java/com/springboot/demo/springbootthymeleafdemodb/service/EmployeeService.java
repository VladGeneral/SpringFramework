package com.springboot.demo.springbootthymeleafdemodb.service;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
