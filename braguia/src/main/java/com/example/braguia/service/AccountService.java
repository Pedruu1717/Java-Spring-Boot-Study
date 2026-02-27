package com.example.braguia;

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

    public boolean addAccount(String number, String agency, BigDecimal balance, String type, Long client_id) {
        Optional<Client> client = clientRepository.findById(client_id);

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
    }

    public BigDecimal getAccountStatement(Long id) {
        Optional<Account> account = this.getAccountById(id);
        if (account.isPresent()) {
            Account a = account.get();
            return a.getBalance();
        } else {
            return new BigDecimal(0);
        }
    }

    public void putAccountDeposit(Long id, BigDecimal value) {
        Optional<Account> account = this.getAccountById(id);
        if (account.isPresent() && value.compareTo(new BigDecimal(0)) > 0) {
            Account a = account.get();
            a.setBalance(a.getBalance().add(value));
        }
    }

    public void putAccountWithdrawal(Long id, BigDecimal value) {
        Optional<Account> account = this.getAccountById(id);
        if (account.isPresent() && value.compareTo(new BigDecimal(0)) > 0) {
            Account a = account.get();
            BigDecimal balance = a.getBalance();
            if (value.compareTo(balance) <= 0) {
                a.setBalance(balance.subtract(value));
            }
        }
    }
}