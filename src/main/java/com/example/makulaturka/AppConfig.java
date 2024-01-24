package com.example.makulaturka;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.account.AccountRepository;
import com.example.makulaturka.address.Address;
import com.example.makulaturka.address.AddressRepository;
import com.example.makulaturka.client.Client;
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
                    null, //"266886@student.pwr.edu.pl"
                    null,
                    "JakCeb",
                    "password"
            );
            Address ad1 = new Address(
                    1L,
                    "Inowroclawska",
                    "6",
                    "12",
                    "53-653",
                    "Wroclaw"
            );
            Client c1 = new Client(
                    1L,
                    a1,
                    ad1,
                    1000L
            );
            accountRepository.saveAll(
                    List.of(a1)
            );
            addressRepository.saveAll(
                    List.of(ad1)
            );
            clientRepository.saveAll(
                    List.of(c1)
            );
        };
    }
}
