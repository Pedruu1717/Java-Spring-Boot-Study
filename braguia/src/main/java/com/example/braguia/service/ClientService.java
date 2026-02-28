package com.example.braguia.service;

import com.example.braguia.entity.Client;
import com.example.braguia.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Exception;

@Service
public class ClientService {
    // Create Bean.
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> getClientByName(String name) {
        return clientRepository.findByName(name);
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll(); // JSON or XML
    }

    public boolean addClient(String name, String email, String password, String NIF, String NIC) {
        try {
            Client client = new Client();
            client.setName(name);
            client.setEmail(email);
            client.setPassword(password);
            client.setNIF(NIF);
            client.setNIC(NIC);
            clientRepository.save(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}