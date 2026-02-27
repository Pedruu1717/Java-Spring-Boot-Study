package com.example.braguia;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Exception;
import java.time.LocalDateTime;

import java.math.BigDecimal;

@Service
public class TransactionService {
    // Create Bean.
    @Autowired
    private final TransactionRepository transactionRepository;
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final ClientRepository clientRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Optional<Transaction> getTransactionByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    public Optional<Transaction> getTransactionByDestinationAccountId(Long destination_account_id) {
        return transactionRepository.findByDestinationAccountId(destination_account_id);
    }

    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll(); // JSON or XML
    }

    public boolean addTransaction(String type, BigDecimal value, LocalDateTime date, Long source_account_id, Long destination_account_id, Long client_id) {
        Optional<Account> source_account = accountRepository.findById(source_account_id);
        Optional<Account> destination_account = accountRepository.findById(destination_account_id);
        Optional<Client> client = clientRepository.findById(client_id);

        try {
            Transaction transaction = new Transaction();
            transaction.setType(type);
            transaction.setValue(value);
            transaction.setDate(date);
            transaction.setSourceAccount(source_account.get());
            transaction.setDestinationAccount(destination_account.get());
            transaction.setClient(client.get());
            transactionRepository.save(transaction);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}