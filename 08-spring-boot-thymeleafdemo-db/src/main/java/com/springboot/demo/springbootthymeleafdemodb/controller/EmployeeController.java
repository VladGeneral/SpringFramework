package com.springboot.demo.springbootthymeleafdemodb.controller;

import com.springboot.demo.springbootthymeleafdemodb.entity.Employee;
import com.springboot.demo.springbootthymeleafdemodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employees.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employees.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }
}
