package com.example.braguia.transaction;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public String addTransaction(@RequestParam TransactionType type, @RequestParam BigDecimal value, @RequestParam Long source_account_id, @RequestParam Long destination_account_id, @RequestParam Long client_id) {
        boolean result = transactionService.addTransaction(type, value, LocalDateTime.now(), source_account_id, destination_account_id, client_id);
        if (result) { return "Saved"; }
        else { return "Could not add transaction"; }
    }

    @GetMapping("/all")
    public Iterable<Transaction> getAllTransactions() {
        Iterable<Transaction> transactions = transactionService.getAllTransactions();

        return transactions;
    }
}