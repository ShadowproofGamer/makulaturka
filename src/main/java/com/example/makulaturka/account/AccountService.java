package com.example.makulaturka.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    /**
     * konstruktor AccountService
     * @param accountRepository referencja do BD kont
     */
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Funkcja zwracająca wszystkie konta
     */
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Funkcja zwracająca dany produkt
     * @param accountId numeryczne Id konta
     */
    public Account getAccount(Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isEmpty()) {
            throw new IllegalStateException("Could not find product with id " + accountId);
        }

        return optionalAccount.get();
    }

    public void addNewAccount() {
        accountRepository.save(new Account());
    }

    public void addNewAccount(Account account) {
        accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    public void editAccount(Account account) {
        //productRepository.deleteById(product.getId());
        accountRepository.save(account);
    }
}
