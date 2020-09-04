package com.springboot.demo.springbootcruddemo.dao;

import com.springboot.demo.springbootcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//8080/employees - default
//@RepositoryRestResource (path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
