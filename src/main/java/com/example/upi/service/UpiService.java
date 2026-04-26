package com.example.upi.service;

import com.example.upi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpiService {

    private Map<String, User> users = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public UpiService() {
        users.put("alice@upi", new User("Alice", "alice@upi", 5000));
        users.put("bob@upi", new User("Bob", "bob@upi", 2000));
    }

    public String transfer(String senderUpi, String receiverUpi, double amount) {

        String txnId = "TXN" + System.currentTimeMillis();

        if (!users.containsKey(senderUpi) || !users.containsKey(receiverUpi)) {
            transactions.add(new Transaction(txnId, senderUpi, receiverUpi, amount, "FAILED - INVALID UPI"));
            return "Invalid UPI ID";
        }

        User sender = users.get(senderUpi);
        User receiver = users.get(receiverUpi);

        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            transactions.add(new Transaction(txnId, senderUpi, receiverUpi, amount, "SUCCESS"));
            return "Payment Successful: " + txnId;
        } else {
            transactions.add(new Transaction(txnId, senderUpi, receiverUpi, amount, "FAILED - INSUFFICIENT BALANCE"));
            return "Insufficient Balance";
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Collection<User> getUsers() {
        return users.values();
    }
}