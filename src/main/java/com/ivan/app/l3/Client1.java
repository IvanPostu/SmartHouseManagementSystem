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
public class Client1 {
    
    private IAirHumidityAnalyzer humidityAnalyzer;
    
    public Client1(IAirHumidityAnalyzer humidityAnalyzer){
        this.humidityAnalyzer = humidityAnalyzer;
    }
    
    public void executeBusinessLogic(){
        
        Map<String, Integer> dailyAnalysisResult = humidityAnalyzer.analyzeRealtimeHumidityData(
              Arrays.asList(1, 2, 3)  
        );
        
        
//        ...logic
    }
    
}
