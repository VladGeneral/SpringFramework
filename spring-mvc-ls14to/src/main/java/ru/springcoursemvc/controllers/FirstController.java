package ru.springcoursemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model) {

//        System.out.println("hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(
            @RequestParam(value = "first", required = false) String first,
            @RequestParam(value = "second", required = false) String second,
            @RequestParam(value = "action", required = false) String action,
            Model model) {
        double a = first == null ? 0 : Double.parseDouble(first);
        double b = second == null ? 0 : Double.parseDouble(second);
        double result = 0;
        switch (action == null ? "" : action) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mul":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
        }
        model.addAttribute("message", String.valueOf(result));
        return "first/calculator";
    }
}
