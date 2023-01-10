package org.lubna.exception;

public class InsufficientFoundsException extends Exception{

    private final double amount;

    public InsufficientFoundsException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
