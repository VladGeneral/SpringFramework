package com.springboot.demo.springbootthymeleafdemodb.controller;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        Employee employee1 = new Employee(1, "name1", "lastname1", "ssds@gmailcom");
        Employee employee2 = new Employee(2, "name2", "lastname2", "ss2@gmailcom");
        Employee employee3 = new Employee(3, "name3", "lastname3", "ss3@gmailcom");

        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}
