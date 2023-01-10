package org.lubna.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final String id;
    private final Customer customer;
    private final TransactionType type;
    private final Double amount;
    private final LocalDateTime dateTime;

    public Transaction(Customer customer, TransactionType type, Double amount, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
