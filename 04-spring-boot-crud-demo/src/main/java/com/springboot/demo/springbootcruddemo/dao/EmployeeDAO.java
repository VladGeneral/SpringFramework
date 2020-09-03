package com.springboot.demo.springbootcruddemo.dao;

import com.springboot.demo.springbootcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
