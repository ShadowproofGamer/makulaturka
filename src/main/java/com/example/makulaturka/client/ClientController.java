package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.address.Address;
import org.springframework.ui.Model;
import com.example.makulaturka.account.AccountService;
import com.example.makulaturka.address.AddressService;
import com.example.makulaturka.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "client")
public class ClientController {
    private final AccountService accountService;
    private final AddressService addressService;
    private final ClientService clientService;

    @Autowired
    public ClientController(AccountService accountService, AddressService addressService, ClientService clientService) {
        this.accountService = accountService;
        this.addressService = addressService;
        this.clientService = clientService;
    }

    @GetMapping
    public String getClient(Model model) {
//        List<Client> clientList = clientService.getClients();
//        model.addAttribute("clientList", clientList);
//        List<Address> addressList = addressService.getAddresses();
//        model.addAttribute("addressList", addressList);
//        List<Account> accountList = accountService.getAccounts();
//        model.addAttribute("accountList", accountList);

        Client client = clientService.getClient(1L);
        model.addAttribute("client", client);
        return "client/index";
    }


}
