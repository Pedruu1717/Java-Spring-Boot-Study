package com.example.braguia.account;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public Optional<Account> findById(Long id);
    public Optional<Account> findByNumber(String number);
    public Optional<Account> findByClientId(Long client_id);
    public Iterable<Account> findAll();
    public Iterable<Account> findAllByClientId(Long client_id);
}