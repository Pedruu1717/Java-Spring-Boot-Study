package com.example.braguia;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public String addAccount(@RequestParam String number, @RequestParam String agency, @RequestParam BigDecimal balance, @RequestParam String type, @RequestParam Long client_id) {
        String t = type.toUpperCase();
        String at;

        if (t.equals(AccountType.CURRENT.name()) || t.equals(AccountType.SAVINGS.name())) {
            at = t;
        } else {
            at = "CURRENT";
        }

        boolean result = accountService.addAccount(number, agency, balance, at, client_id);

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

    @PutMapping("/deposit")
    public void putAccountDeposit(@RequestParam Long id, @RequestParam BigDecimal value) {
        accountService.putAccountDeposit(id, value);
    }

    @PutMapping("/withdrawal")
    public void putAccountWithdrawal(@RequestParam Long id, @RequestParam BigDecimal value) {
        accountService.putAccountWithdrawal(id,value);
    }
}