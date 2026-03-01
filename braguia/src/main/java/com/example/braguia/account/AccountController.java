package com.example.braguia.account;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public String addAccount(@RequestParam String number, @RequestParam String agency, @RequestParam BigDecimal balance, @RequestParam AccountType type, @RequestParam Long client_id) {
        boolean result = accountService.addAccount(number, agency, balance, type, client_id);
        if (result) { return "Saved"; }
        else { return "Could not add account"; }
    }

    @GetMapping("/all")
    public Iterable<Account> getAllAccounts() {
        Iterable<Account> accounts = accountService.getAllAccounts();

        return accounts;
    }

    @GetMapping("/statement")
    public BigDecimal getAccountStatement(@RequestParam Long id) {
        BigDecimal statement = accountService.getAccountStatement(id);

        return statement;
    }
}