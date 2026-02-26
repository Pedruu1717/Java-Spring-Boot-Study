package com.example.braguia;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping("/api/monument")
public class MonumentController {
    private final MonumentService monumentService;

    public MonumentController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @PostMapping("/add")
    public String addMonument(@RequestParam String name, @RequestParam String description, @RequestParam String imgUrl) {
        description = description != null ? description : "";
        imgUrl = imgUrl != null ? imgUrl : "";

        boolean result = monumentService.addMonument(name, description, imgUrl);

        if (result) { return "Saved"; }
        else { return "Could not add monument"; }
    }

    @GetMapping("/all")
    public String getAllMonuments() {
        Iterable<Monument> monuments = monumentService.getAllMonuments();
        String monums = "";

        for (Monument m : monuments) {
            monums += m.toString() + "\n";
        }

        return monums;
    }

    @GetMapping("/by-name/{name}")
    public String getMonumentByName(@RequestParam String name) {
        Optional<Monument> monument = monumentService.getMonumentByName(name);
        if (monument.isPresent()) {
            Monument m = monument.get();
            return m.toString();
        } else {
            return "Monument not found";
        }
    }
}