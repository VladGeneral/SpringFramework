package com.springboot.demo.springbootthymeleafdemodb.controller;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;
import com.springboot.demo.springbootthymeleafdemodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private EmployeeService employees;

    @Autowired
    public EmployeeController(EmployeeService employees) {
        this.employees = employees;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employees.findAll());
        return "list-employees";
    }
}
