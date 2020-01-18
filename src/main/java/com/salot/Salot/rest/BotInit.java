package com.salot.Salot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController (value = "")
public class BotInit {

    @GetMapping
    public String botInitiator(){

        return "Bot Iniciado";
    }
}
