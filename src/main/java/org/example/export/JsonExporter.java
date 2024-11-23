package org.example.export;

import org.example.domen.SummaryStatistics;

public class JsonExporter implements Exporter{

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        return "{\n" +
                " \"sum\": " + summaryStatistics.getSum() + ",\n" +
                " \"average\": " + summaryStatistics.getAverage() + ",\n" +
                " \"max\": " + summaryStatistics.getMax() + ",\n" +
                " \"min\": " + summaryStatistics.getMin() + "\n" +
                "}";
    }
}
