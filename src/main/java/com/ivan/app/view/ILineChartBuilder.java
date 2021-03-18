/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.BasicStroke;
import java.awt.Color;

/**
 *
 * @author ivan
 */
public interface ILineChartBuilder extends IChartBuilder {
    
    ILineChartBuilder setLineColor(int series, Color color);
    
    ILineChartBuilder setLineWeight(int series, BasicStroke b);
    
}
