package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller ,ethod to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller ,ethod to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //read from data
    @RequestMapping("/processFormVersionTwo")
    public String doUpperCase(HttpServletRequest request, Model model) {
        String result = request.getParameter("studentName").toUpperCase();
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String doUpperCaseVersionThree(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message", "uppercase versionThree: " + name.toUpperCase());
        return "helloworld";
    }
}
