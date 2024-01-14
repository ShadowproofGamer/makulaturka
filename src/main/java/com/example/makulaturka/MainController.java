package com.example.makulaturka;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    public MainController() {
    }

    @GetMapping
    public String mainIndex() {
        return "main/index";
    }
}
