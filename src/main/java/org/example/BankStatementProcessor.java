package org.example;

import org.example.domen.BankTransaction;
import org.example.domen.SummaryStatistics;
import org.example.functionalInterfaces.BankTransactionFilter;
import org.example.functionalInterfaces.BankTransactionSummarizer;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }



    public SummaryStatistics summarizeTransactions() {
        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(bankTransaction -> Double.parseDouble(bankTransaction.getAmount()))
                .summaryStatistics();
        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

//    public double summarizeTransactions(final BankTransactionSummarizer summarizer) {
//        double result = 0;
//        for (final BankTransaction bankTransaction : bankTransactions) {
//            result = summarizer.summarize(result, bankTransaction);
//        }
//        return result;
//    }
//    public double calculateTotalInMonth(final Month month) {
//        return summarizeTransactions((acc, bankTransaction) ->
//                LocalDate.parse(bankTransaction.getDate(), DATE_PATTERN).getMonth() == month ? acc + Double.parseDouble(bankTransaction.getAmount()) : acc);
//    }




    public List<BankTransaction> findTransactions(final BankTransactionFilter filter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (filter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> Double.parseDouble(bankTransaction.getAmount()) >= amount);
    }
}
