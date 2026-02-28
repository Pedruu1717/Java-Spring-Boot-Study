package com.example.braguia.controller;

import com.example.braguia.entity.Client;
import com.example.braguia.service.ClientService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public String addClient(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String NIF, @RequestParam String NIC) {
        boolean result = clientService.addClient(name, email, password, NIF, NIC);

        if (result) { return "Saved"; }
        else { return "Could not add client"; }
    }

    @GetMapping("/all")
    public Iterable<Client> getAllClients() {
        Iterable<Client> clients = clientService.getAllClients();

        return clients;
    }
}