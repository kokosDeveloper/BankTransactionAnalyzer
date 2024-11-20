package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//сумма начислений и списаний
//сколько транзакций
//10 самых затратных операций
//на что больше всего потрачен
public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }
    private static void collectSummary(BankStatementProcessor processor){
        System.out.println("The total for all transactions is " + processor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + processor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total salary received is " + processor.calculateTotalForCategory("Salary"));
    }
}