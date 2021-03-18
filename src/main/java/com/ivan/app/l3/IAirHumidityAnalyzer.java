package com.ivan.app.l3;

import java.util.List;
import java.util.Map;

public interface IAirHumidityAnalyzer {
    
    Map<String, Integer> analyzeDailyHumidityData(List<Integer> dailyHumidity);
    
    Map<String, Integer> analyzeRealtimeHumidityData(List<Integer> realtimeHumidity);
    
    Map<String, Integer> generateReport();
}
