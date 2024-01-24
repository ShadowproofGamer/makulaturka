package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.address.Address;
import org.springframework.ui.Model;
import com.example.makulaturka.account.AccountService;
import com.example.makulaturka.address.AddressService;
import com.example.makulaturka.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
        Client client = clientService.getClient(1L);
        Address address = client.getAddress();
        Account account = client.getAccount();
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        model.addAttribute("account", account);
        return "client/index";
    }

    @PostMapping("/editAccount")
    public String editClientAccount(@ModelAttribute("account") Account account, @ModelAttribute("client") Client client, Model model) {
        model.addAttribute("clientId", client.getId());
        model.addAttribute("account", account);
        return "client/editAccount";
    }

    //@RequestParam("clientId") Long clientId,
    @PostMapping("/editAccountU")
    public String editClientAccountU(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, Model model) {
        return getString(clientId, account, model);
    }

    @PostMapping("/editAddress")
    public String editClientAddress(@ModelAttribute("address") Address address, @ModelAttribute("client") Client client, Model model) {
        model.addAttribute("clientId", client.getId());
        model.addAttribute("address", address);
        //model.addAttribute("account", account);
        return "client/editAddress";
    }

    @PostMapping("/editAddressU")
    public String editClientAddressU(@RequestParam("clientId") Long clientId, @ModelAttribute("address") Address address, Model model) {
        addressService.editAddress(address);
        Client client = clientService.getClient(clientId);
        Account account = client.getAccount();
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        model.addAttribute("account", account);
        return "client/index";
    }

    @GetMapping("/changePassword")
    public String editClientPassword(@RequestParam("clientId") Long clientId, Model model) {
        //@ModelAttribute("account") Account account, @ModelAttribute("client") Client client
        model.addAttribute("clientId", clientId);
        Account account = clientService.getClient(clientId).getAccount();
        model.addAttribute("account", account);
        model.addAttribute("errorPass", "");
        return "client/changePassword";
    }

    //@RequestParam("clientId") Long clientId,
    @PostMapping("/changePasswordU")
    public String editClientPasswordU(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, @RequestParam("passwordConfirm") String confirmPass, Model model) {
        if (!Objects.equals(account.getPassword(), confirmPass)){
            model.addAttribute("clientId", clientId);
            model.addAttribute("account", account);
            model.addAttribute("errorPass", "Hasła muszą być identyczne!");
            return "client/changePassword";
        }
        return getString(clientId, account, model);
    }

    private String getString(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, Model model) {
        accountService.editAccount(account);
        Client client = clientService.getClient(clientId);
        Address address = client.getAddress();
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        model.addAttribute("account", account);
        return "client/index";
    }

}
