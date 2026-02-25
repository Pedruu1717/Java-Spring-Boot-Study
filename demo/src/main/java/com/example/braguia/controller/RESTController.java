package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RESTController {

    private static final String byeTemplate = "Adeus, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/bye")
    public Goodbye bye(@RequestParam(value = "name", defaultValue = "Sr. Anderson") String name) {
        return new Goodbye(counter.incrementAndGet(), byeTemplate.formatted(name));
    }
}