/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.Font;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author ivan
 */
public class LineChart implements IChart {

    private JFreeChart chart;


    public LineChart(JFreeChart chart) {
        this.chart = chart;
    }
    
    
    
    @Override
    public JFreeChart getChart() {
        return chart;
    }
    
}
