package com.example.braguia;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ViewController {

    private final MonumentController monumentController;

    public ViewController(MonumentController monumentController) {
        this.monumentController = monumentController;
    }

    @GetMapping("/monuments")
    public String monuments(Model model) {
        String monuments = monumentController.getAllMonuments();
        model.addAttribute("monuments", monuments);

        return "monuments";
    }

    @GetMapping("/monuments/{name}")
    public String monument(@RequestParam (name="name") String name, Model model) {
        String monument = monumentController.getMonumentByName(name);
        model.addAttribute("monument", monument);

        return "monument";
    }
}