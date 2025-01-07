package com.bank.bankingapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;
    private BigDecimal amount;
    private String type; // "credit" or "debit"
    private LocalDateTime timestamp;
    private String description;

    public Transaction() {
    }
    public Transaction(String transactionId, BigDecimal amount, String type, LocalDateTime timestamp, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.description = description;
    }
    // Getters and setters

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
