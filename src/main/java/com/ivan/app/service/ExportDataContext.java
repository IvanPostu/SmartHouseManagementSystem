/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class ExportDataContext {
    
    private ExportDataSerciveStrategy strategy;
    
    public ExportDataContext(ExportDataSerciveStrategy strategy){
        this.strategy = strategy;
    }
    
    public void setStrategy(ExportDataSerciveStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public void exportData(Map<String, List<String>> data, String fileName){
         this.strategy.exportData(data, fileName);
    }
}
