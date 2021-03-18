/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.l3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class AirHumidityAnalyzer implements IAirHumidityAnalyzer{

    @Override
    public Map<String, Integer> analyzeDailyHumidityData(List<Integer> dailyHumidity) {
        /**
         * Implementation ...
         */
        return new HashMap<>();
    }

    @Override
    public Map<String, Integer> analyzeRealtimeHumidityData(List<Integer> realtimeHumidity) {
         /**
         * Implementation ...
         */
        return new HashMap<>();
    }

    @Override
    public Map<String, Integer> generateReport() {
         /**
         * Implementation ...
         */
        return new HashMap<>();
    }
    
}
