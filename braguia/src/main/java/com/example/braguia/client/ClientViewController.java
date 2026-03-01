package com.example.braguia.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientViewController {

    private final ClientController clientController;

    public ClientViewController(ClientController clientController) {
        this.clientController = clientController;
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        Iterable<Client> clients = clientController.getAllClients();
        model.addAttribute("clients", clients);

        return "clients";
    }
}
