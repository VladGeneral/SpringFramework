package com.springboot.demo.springbootthymeleafdemodb.dao;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
