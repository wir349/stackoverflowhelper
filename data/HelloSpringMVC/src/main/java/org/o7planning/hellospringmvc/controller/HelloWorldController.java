package org.o7planning.hellospringmvc.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        Date date = new Date(0);
        date.setTime(23 * 60 * 60 * 1000);
        
        return "helloworld";
        
    }
}