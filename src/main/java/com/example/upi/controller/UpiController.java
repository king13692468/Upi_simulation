package com.example.upi.controller;

import com.example.upi.model.Transaction;
import com.example.upi.model.User;
import com.example.upi.service.UpiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UpiController {

    @Autowired
    private UpiService service;

    // Payment API
    @PostMapping("/pay")
    public String pay(@RequestParam String sender,
                      @RequestParam String receiver,
                      @RequestParam double amount) {

        return service.transfer(sender, receiver, amount);
    }

    // Transaction history
    @GetMapping("/history")
    public List<Transaction> history() {
        return service.getTransactions();
    }

    // Users
    @GetMapping("/users")
    public Collection<User> users() {
        return service.getUsers();
    }
}