package org.example.domen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BankTransaction {
    private final LocalDate date;
    private final Double amount;
    private final String description;

    public BankTransaction(LocalDate date, Double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }


    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
