package com.example.braguia;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class ViewController {

    private final ClientController clientController;
    private final AccountController accountController;
    private final TransactionController transactionController;

    public ViewController(ClientController clientController, AccountController accountController, TransactionController transactionController) {
        this.clientController = clientController;
        this.accountController = accountController;
        this.transactionController = transactionController;
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        Iterable<Client> clients = clientController.getAllClients();
        model.addAttribute("clients", clients);

        return "clients";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        Iterable<Account> accounts = accountController.getAllAccounts();
        model.addAttribute("accounts", accounts);

        return "accounts";
    }

    @GetMapping("/transactions")
    public String transactions(Model model) {
        Iterable<Transaction> transactions = transactionController.getAllTransactions();
        model.addAttribute("transactions", transactions);

        return "transactions";
    }
}