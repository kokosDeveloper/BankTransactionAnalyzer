package org.example;


import org.example.domen.BankTransaction;
import org.example.domen.SummaryStatistics;
import org.example.export.Exporter;
import org.example.parser.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

//сумма начислений и списаний
//сколько транзакций
//10 самых затратных операций
//на что больше всего потрачен

//поиск по определенным транзакциям
//экспорт статистики в другой формат
public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser, final Exporter exporter) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();
        System.out.println(exporter.export(summaryStatistics));
    }
}