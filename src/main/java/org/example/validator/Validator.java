package org.example.validator;

import org.example.domen.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Validator {
    private String description;
    private String date;
    private String amount;
    private DateTimeFormatter datePattern;

    public Validator(final String description, final String date, final String amount, DateTimeFormatter datePattern) {
        this.description = Objects.requireNonNull(description, "Description cannot be null");
        this.date = Objects.requireNonNull(date, "Date cannot be null");
        this.amount = Objects.requireNonNull(amount, "Amount cannot be null");
        this.datePattern = datePattern;
    }

    public Notification validate(){
        final Notification notification = new Notification();
        if(this.description.length() > 100)
            notification.addError("The description is too long");
        final LocalDate parsedDate;
        try{
            parsedDate = LocalDate.parse(this.date, datePattern);
            if(parsedDate.isAfter(LocalDate.now()))
                notification.addError("Date cannot be in the future");
        }catch (DateTimeParseException e){
            notification.addError("Invalid format for date");
        }
        final double amount;
        try{
            amount = Double.parseDouble(this.amount);
        }catch (NumberFormatException e){
            notification.addError("Invalid format for amount");
        }
        return notification;
    }
}
