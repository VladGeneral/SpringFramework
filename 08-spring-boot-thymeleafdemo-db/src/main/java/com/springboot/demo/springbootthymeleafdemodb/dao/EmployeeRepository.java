package com.springboot.demo.springbootthymeleafdemodb.dao;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
