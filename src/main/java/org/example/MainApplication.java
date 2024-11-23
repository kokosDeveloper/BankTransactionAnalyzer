package org.example;

import org.example.export.Exporter;
import org.example.export.HtmlExporter;
import org.example.export.JsonExporter;
import org.example.parser.BankStatementCSVParser;
import org.example.parser.BankStatementParser;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parser = new BankStatementCSVParser();
        final Exporter exporter = new JsonExporter();

        analyzer.analyze(args[0], parser, exporter);
    }
}
