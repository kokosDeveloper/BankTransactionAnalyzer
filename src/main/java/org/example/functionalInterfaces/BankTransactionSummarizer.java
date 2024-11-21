package org.example.functionalInterfaces;

import org.example.domen.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
