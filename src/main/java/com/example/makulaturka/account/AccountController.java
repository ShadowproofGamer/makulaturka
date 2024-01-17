package com.example.makulaturka.account;

import com.example.makulaturka.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="account")
public class AccountController {
    private final AccountService accountService;
    private final AddressService addressService;

    @Autowired
    public AccountController(AccountService accountService, AddressService addressService) {
        this.accountService = accountService;
        this.addressService = addressService;
    }




}
