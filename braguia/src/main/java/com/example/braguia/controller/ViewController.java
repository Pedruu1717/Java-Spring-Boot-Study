package com.example.braguia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/monuments/{name}")
    public String monuments(@PathVariable String name, Model model) {
        // Make value of parameter "name" accessible to the View template through a Model object.
        model.addAttribute("name", name);

        // @TODO retrieve img from database based on "name" variable
        model.addAttribute("img_url", "https://google.pt");

        // Return view monuments.html
        return "monuments";
    }
}