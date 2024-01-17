package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.account.AccountRepository;
import com.example.makulaturka.client.Client;
import com.example.makulaturka.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);

        if (optionalClient.isEmpty()) {
            throw new IllegalStateException("Could not find client with id " + clientId);
        }

        return optionalClient.get();
    }

    public void addNewClient() {
        clientRepository.save(new Client());
    }

    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public void editClient(Client client) {
        clientRepository.save(client);
    }
}
