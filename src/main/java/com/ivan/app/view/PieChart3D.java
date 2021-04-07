/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author ivan
 */
public class PieChart3D implements IChart {
        private JFreeChart chart;


    public PieChart3D(JFreeChart chart) {
        this.chart = chart;
    }
    
    
    
    @Override
    public JFreeChart getChart() {
        return chart;
    }
}
