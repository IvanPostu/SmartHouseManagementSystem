/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.l3;

import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class Client2 {

    private IAirHumidityAnalyzer humidityAnalyzer;

    public Client2(IAirHumidityAnalyzer humidityAnalyzer) {
        this.humidityAnalyzer = humidityAnalyzer;
    }

    public void executeBusinessLogic() {

        Map<String, Integer> dailyAnalysisResult = humidityAnalyzer.analyzeDailyHumidityData(
                Arrays.asList(1, 2, 3)
        );

        Map<String, Integer> report = humidityAnalyzer.generateReport();

//        ...logic
    }
}
