package com.example.braguia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/monument")
public class MonumentController {
    @Autowired

    private MonumentRepository monumentRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewMonument(@RequestParam String name, @RequestParam String description) {
        Monument m = new Monument();
        m.setName(name);
        m.setDescription(description);
        monumentRepository.save(m);

        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Monument> getAllMonuments() {
        return monumentRepository.findAll(); // JSON or XML
    }

    /*GetMapping("/monuments/{id}")
    public String monuments(@PathVariable Integer id) {
        return userRepository.findById(id);
    }*/
}