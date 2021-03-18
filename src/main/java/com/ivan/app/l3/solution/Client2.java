/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.l3.solution;

import com.ivan.app.l3.*;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class Client2 {

    private IRealtimeAirHumidityAnalyzer analyzer;
    private IReportGenerator reportGenerator;

    public Client2(IRealtimeAirHumidityAnalyzer analyzer, IReportGenerator reportGenerator) {
        this.analyzer = analyzer;
        this.reportGenerator = reportGenerator;
    }

    public void executeBusinessLogic() {

        Map<String, Integer> dailyAnalysisResult = analyzer.analyze(
                Arrays.asList(1, 2, 3)
        );

        Map<String, Integer> report = reportGenerator.generateReport();

//        ...logic
    }
}
