package com.example.makulaturka;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.account.AccountRepository;
import com.example.makulaturka.address.AddressRepository;
import com.example.makulaturka.client.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, AddressRepository addressRepository, ClientRepository clientRepository) {
        return args -> {
            Account a1 = new Account(
                    1L,
                    "Jakub",
                    "Cebula",
                    "266886@student.pwr.edu.pl",
                    "123456789",
                    "JakCeb",
                    "password"
            );
            accountRepository.saveAll(
                    List.of(a1)
            );
        };
    }
}
