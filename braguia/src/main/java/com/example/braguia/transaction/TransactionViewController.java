package com.example.braguia.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionViewController {

    private final TransactionController transactionController;

    public TransactionViewController(TransactionController transactionController) {
        this.transactionController = transactionController;
    }

    @GetMapping("/transactions")
    public String transactions(Model model) {
        Iterable<Transaction> transactions = transactionController.getAllTransactions();
        model.addAttribute("transactions", transactions);

        return "transactions";
    }
}
