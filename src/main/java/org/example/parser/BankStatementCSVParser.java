package org.example.parser;

import org.example.domen.BankTransaction;
import org.example.domen.Notification;
import org.example.validator.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser{
private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public BankTransaction parseFrom(final String line){
        final String[] columns = line.split(",");

        final String stringDate = columns[0];
        final String stringAmount = columns[1];
        final String description = columns[2];


        Validator validator = new Validator(description, stringDate, stringAmount, DATE_PATTERN);
        final Notification notification = validator.validate();
        if(notification.hasErrors()){
            throw new IllegalArgumentException("Validation errors: " + notification.getErrors());
        }


        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final Double amount = Double.parseDouble(columns[1]);


        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines){
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
