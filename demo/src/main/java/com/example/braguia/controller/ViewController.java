package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Sr. Anderson") String name, Model model) {
        // Make value of parameter "name" accessible to the View template through a Model object.
        model.addAttribute("name", name);

        // Return view hello.html.
        return "hello";
    }

}