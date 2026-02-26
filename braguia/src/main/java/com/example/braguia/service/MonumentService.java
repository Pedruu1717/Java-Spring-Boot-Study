package com.example.braguia;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Exception;

@Service
public class MonumentService {
    // Create Bean.
    @Autowired
    private final MonumentRepository monumentRepository;

    public MonumentService(MonumentRepository monumentRepository) {
        this.monumentRepository = monumentRepository;
    }

    public Optional<Monument> getMonumentByName(String name) {
        return monumentRepository.findByName(name);
    }

    public Iterable<Monument> getAllMonuments() {
        return monumentRepository.findAll(); // JSON or XML
    }

    public boolean addMonument(String name, String description, String imgUrl) {
        try {
            Monument m = new Monument();
            m.setName(name);
            m.setDescription(description);
            m.setImgUrl(imgUrl);
            monumentRepository.save(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}