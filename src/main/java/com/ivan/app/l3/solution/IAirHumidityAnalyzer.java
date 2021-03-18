package com.ivan.app.l3.solution;

import com.ivan.app.l3.*;
import java.util.List;
import java.util.Map;

public interface IAirHumidityAnalyzer {
    
    Map<String, Integer> analyze(List<Integer> dailyHumidity);

}
