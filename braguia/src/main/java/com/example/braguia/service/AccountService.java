package com.example.braguia.service;

import com.example.braguia.entity.Account;
import com.example.braguia.entity.Client;
import com.example.braguia.enums.AccountType;
import com.example.braguia.repository.AccountRepository;
import com.example.braguia.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Exception;

import java.math.BigDecimal;

@Service
public class AccountService {
    // Create Bean.
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final ClientRepository clientRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> getAccountByNumber(String number) {
        return accountRepository.findByNumber(number);
    }

    public Optional<Account> getAccountByClientId(Long client_id) {
        return accountRepository.findByClientId(client_id);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll(); // JSON or XML
    }

    public boolean addAccount(String number, String agency, BigDecimal balance, AccountType type, Long client_id) {
        Optional<Client> client = clientRepository.findById(client_id);
        if (client.isPresent()) {
            try {
                Account account = new Account();
                account.setNumber(number);
                account.setAgency(agency);
                account.setBalance(balance);
                account.setType(type);
                account.setClient(client.get());
                accountRepository.save(account);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else  {
            return false;
        }
    }

    public BigDecimal getAccountStatement(Long id) {
        Optional<Account> account = this.getAccountById(id);
        if (account.isPresent()) {
            Account acc = account.get();
            return acc.getBalance();
        } else {
            return new BigDecimal(0);
        }
    }
}