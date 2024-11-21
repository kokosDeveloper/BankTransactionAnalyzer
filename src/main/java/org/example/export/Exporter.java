package org.example.export;

import org.example.domen.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
