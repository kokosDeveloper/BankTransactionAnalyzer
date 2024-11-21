package org.example.parser;

import org.example.domen.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser{

    @Override
    public BankTransaction parseFrom(final String line){
        final String[] columns = line.split(",");


        final String date = columns[0];
        final String amount = columns[1];
        final String description = columns[2];

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
