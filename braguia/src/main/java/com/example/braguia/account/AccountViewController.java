package com.example.braguia.account;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AccountViewController {

    private final AccountController accountController;

    public AccountViewController(AccountController accountController) {
        this.accountController = accountController;
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        Iterable<Account> accounts = accountController.getAllAccounts();
        model.addAttribute("accounts", accounts);

        return "accounts";
    }
}
