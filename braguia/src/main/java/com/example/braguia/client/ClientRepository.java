package com.example.braguia.client;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client, Long> {
    public Optional<Client> findById(Long id);
    public Optional<Client> findByName(String name);
    public Optional<Client> findByEmail(String email);
    public Iterable<Client> findAll();
}