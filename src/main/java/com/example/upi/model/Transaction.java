package com.example.upi.model;

public class Transaction {
    private String txnId;
    private String senderUpi;
    private String receiverUpi;
    private double amount;
    private String status;

    public Transaction(String txnId, String senderUpi, String receiverUpi, double amount, String status) {
        this.txnId = txnId;
        this.senderUpi = senderUpi;
        this.receiverUpi = receiverUpi;
        this.amount = amount;
        this.status = status;
    }

    public String getTxnId() { return txnId; }
    public String getStatus() { return status; }
}