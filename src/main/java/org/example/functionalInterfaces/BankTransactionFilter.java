package org.example.functionalInterfaces;

import org.example.domen.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(final BankTransaction bankTransaction);
}
