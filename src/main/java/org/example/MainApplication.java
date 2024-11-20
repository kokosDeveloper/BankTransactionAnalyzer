package org.example;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parser = new BankStatementCSVParser();

        analyzer.analyze(args[0], parser);
    }
}
