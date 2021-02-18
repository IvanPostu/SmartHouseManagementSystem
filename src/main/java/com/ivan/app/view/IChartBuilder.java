/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author ivan
 */
public interface IChartBuilder {

    JFreeChart build();

    IChartBuilder setCategoryDataset(CategoryDataset dataset);

    IChartBuilder setTitle(String title);

    IChartBuilder setCategoryAxisLabel(String categoryAxisLabel);

    IChartBuilder setValueAxisLabel(String valueAxisLabel);

    IChartBuilder setAxisRange(int min, int max);
    
    IChartBuilder setTickUnit(NumberTickUnit tickUnit);

    IChartBuilder setSeriesPaint(int series, Paint paint);

    IChartBuilder setSeriesStroke(int series, Stroke stroke);

    IChartBuilder setOutlinePaint(Paint paint);

    IChartBuilder setOutlineStroke(Stroke stroke);

    IChartBuilder setBackgroundPaint(Paint paint);

    IChartBuilder setRangeGridlinesVisible(boolean visible);

    IChartBuilder setRangeGridlinePaint(Paint paint);

    IChartBuilder setDomainGridlinesVisible(boolean visible);

    IChartBuilder setDomainGridlinePaint(Paint paint);
}
