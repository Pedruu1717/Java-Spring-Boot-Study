package com.example.braguia.repository;

import com.example.braguia.entity.Transaction;
import com.example.braguia.enums.TransactionType;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    public Optional<Transaction> findById(Long id);
    public Optional<Transaction> findByType(TransactionType type);
    public Optional<Transaction> findByDestinationAccountId(Long destination_account_id);
    public Iterable<Transaction> findAll();
}