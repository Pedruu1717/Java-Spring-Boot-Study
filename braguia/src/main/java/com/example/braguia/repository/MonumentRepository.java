package com.example.braguia;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface MonumentRepository extends CrudRepository<Monument, Integer> {
    public Optional<Monument> findById(Integer id);
    public Optional<Monument> findByName(String name);
    public Optional<Monument> findByDescription(String descprition);
    public Optional<Monument> findByimgUrl(String imgUrl);
    public Iterable<Monument> findAll();
}