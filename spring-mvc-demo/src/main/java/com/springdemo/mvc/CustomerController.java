package com.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //adding an init binder to convert trim input strings
    //remove leading and trailing whitespace
    //resolve issue for our validation

    //pre processor annotation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        //convert whitespace string to null or trim whitespaces
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";

    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {
        System.out.println("Last name: |" + customer.getLastName() + "|");

        System.out.println("Binding result: " + bindingResult);

        System.out.println("\n\n\n\n\n");

        if (bindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
