package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.address.Address;
import org.springframework.ui.Model;
import com.example.makulaturka.account.AccountService;
import com.example.makulaturka.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping(path = "client")
public class ClientController {
    private final AccountService accountService;
    private final AddressService addressService;
    private final ClientService clientService;

    /**
     * konstruktor kontrolera klienta
     * @param accountService klasa pozwalająca na komunikację z BD kont
     * @param addressService klasa pozwalająca na komunikację z BD adresów
     * @param clientService klasa pozwalająca na komunikację z BD klientów
     */
    @Autowired
    public ClientController(AccountService accountService, AddressService addressService, ClientService clientService) {
        this.accountService = accountService;
        this.addressService = addressService;
        this.clientService = clientService;
    }

    /**
     * kontroler głównego widoku
     * @param model Model
     * @return ścieżka do menu konta (redirect:client/index)
     */
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

    /**
     * kontroler widoku zmiany danych konta
     * @param account referencja do obiektu danych konta
     * @param client referencja do obiektu klienta
     * @param model Model
     * @return ścieżka do widoku zmiany konta (redirect:client/editAccount)
     */
    @PostMapping("/editAccount")
    public String editClientAccount(@ModelAttribute("account") Account account, @ModelAttribute("client") Client client, Model model) {
        model.addAttribute("clientId", client.getId());
        model.addAttribute("account", account);
        return "client/editAccount";
    }

    /**
     * kontroler widoku zmiany danych konta
     * @param clientId numeryczne Id klienta
     * @param account referencja do obiektu danych konta
     * @param model Model
     * @return ścieżka do menu konta (redirect:client/index)
     */
    @PostMapping("/editAccountU")
    public String editClientAccountU(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, Model model) {
        return updateAccountAndReturn(clientId, account, model);
    }

    /**
     * kontroler widoku zmiany danych adresowych
     * @param address referencja do obiektu danych adresowych
     * @param client referencja do obiektu klienta
     * @param model Model
     * @return ścieżka do widoku zmiany adresu (redirect:client/editAddress)
     */
    @PostMapping("/editAddress")
    public String editClientAddress(@ModelAttribute("address") Address address, @ModelAttribute("client") Client client, Model model) {
        model.addAttribute("clientId", client.getId());
        model.addAttribute("address", address);
        //model.addAttribute("account", account);
        return "client/editAddress";
    }

    /**
     * kontroler widoku zmiany danych adresowych
     * @param clientId numeryczne Id klienta
     * @param address referencja do obiektu danych adresowych
     * @param model Model
     * @return ścieżka do menu konta (redirect:client/index)


     */
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

    /**
     * kontroler widoku zmiany hasła
     * @param clientId numeryczne Id klienta
     * @param model Model
     * @return ścieżka do widoku zmiany hasła (redirect:client/changePassword)
     */
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

    /**
     * kontroler zarządzający zmianą hasła
     * @param clientId numeryczne Id klienta
     * @param account referencja do obiektu danych konta
     * @param confirmPass powtórzone hasło konieczne do weryfikacji poprawności
     * @param model Model
     * @return ścieżka do widoku zmiany hasła (redirect:client/changePassword) w przypadku pomyłki we wpisywaniu
     * lub ścieżka do menu konta (po wywołaniu updateAccountAndReturn())
     */
    @PostMapping("/changePasswordU")
    public String editClientPasswordU(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, @RequestParam("passwordConfirm") String confirmPass, Model model) {
        if (!Objects.equals(account.getPassword(), confirmPass)){
            model.addAttribute("clientId", clientId);
            model.addAttribute("account", account);
            model.addAttribute("errorPass", "Hasła muszą być identyczne!");
            return "client/changePassword";
        }
        return updateAccountAndReturn(clientId, account, model);
    }

    /**
     * Funkcja aktualizująca dane konta klienta i zwracająca klienta i jego adres do widoku konta
     * @param clientId numeryczne Id klienta
     * @param account referencja do obiektu danych konta
     * @param model Model
     * @return ścieżka do menu konta (redirect:client/index)
     */
    private String updateAccountAndReturn(@RequestParam("clientId") Long clientId, @ModelAttribute("account") Account account, Model model) {
        accountService.editAccount(account);
        Client client = clientService.getClient(clientId);
        Address address = client.getAddress();
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        model.addAttribute("account", account);
        return "client/index";
    }

}
