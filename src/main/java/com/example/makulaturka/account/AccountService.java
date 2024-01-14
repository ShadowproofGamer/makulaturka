package com.example.makulaturka.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(Long productId) {
        Optional<Account> optionalAccount = accountRepository.findById(productId);

        if (optionalAccount.isEmpty()) {
            throw new IllegalStateException("Could not find product with id " + productId);
        }

        return optionalAccount.get();
    }

    //TODO adding account
    public void addNewAccount() {
        accountRepository.save(new Account());
    }

    public void addNewAccount(Account product) {
        accountRepository.save(product);
    }

    public void deleteAccount(Long productId) {
        accountRepository.deleteById(productId);
    }

    public void editAccount(Account product) {
        //productRepository.deleteById(product.getId());
        accountRepository.save(product);
    }
}
