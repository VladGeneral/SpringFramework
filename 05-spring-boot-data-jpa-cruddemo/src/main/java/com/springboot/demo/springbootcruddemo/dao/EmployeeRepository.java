package com.springboot.demo.springbootcruddemo.dao;

import com.springboot.demo.springbootcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
