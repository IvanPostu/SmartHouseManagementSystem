/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author ivan
 */
public class LineChartBuilder implements IChartBuilder {

    private CategoryDataset dataset;
    private String title;
    private String categoryAxisLabel;
    private String valueAxisLabel;
    private int mixAxisRange, maxAxisRange;
    private NumberTickUnit tickUnit;
    private LineAndShapeRenderer renderer = new LineAndShapeRenderer();
    private Paint outlinePaint;
    private Stroke outlineStroke;
    private Paint backgroundPaint;
    private boolean rangeGridlinesVisible;
    private Paint rangeGridlinePaint;
    private boolean domainGridlinesVisible;
    private Paint domainGridlinePaint;

    @Override
    public JFreeChart build() {
        JFreeChart chart = ChartFactory.createLineChart(title,
                categoryAxisLabel, valueAxisLabel, dataset);

        CategoryPlot plot = chart.getCategoryPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(mixAxisRange, maxAxisRange);
        rangeAxis.setTickUnit(tickUnit);

        plot.setOutlinePaint(outlinePaint);
        plot.setOutlineStroke(outlineStroke);

        plot.setBackgroundPaint(backgroundPaint);
        plot.setRangeGridlinesVisible(rangeGridlinesVisible);
        plot.setRangeGridlinePaint(rangeGridlinePaint);

        plot.setDomainGridlinesVisible(domainGridlinesVisible);
        plot.setDomainGridlinePaint(domainGridlinePaint);

        plot.setRenderer(renderer);

        return chart;
    }

    @Override
    public IChartBuilder setCategoryDataset(CategoryDataset dataset) {
        this.dataset = dataset;

        return this;
    }

    @Override
    public IChartBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public IChartBuilder setCategoryAxisLabel(String categoryAxisLabel) {
        this.categoryAxisLabel = categoryAxisLabel;
        return this;
    }

    @Override
    public IChartBuilder setValueAxisLabel(String valueAxisLabel) {
        this.valueAxisLabel = valueAxisLabel;
        return this;
    }

    @Override
    public IChartBuilder setAxisRange(int min, int max) {
        this.mixAxisRange = min;
        this.maxAxisRange = max;
        return this;
    }

    @Override
    public IChartBuilder setTickUnit(NumberTickUnit tickUnit) {
        this.tickUnit = tickUnit;
        return this;
    }

    @Override
    public IChartBuilder setSeriesPaint(int series, Paint paint) {
        renderer.setSeriesPaint(series, paint);
        return this;
    }

    @Override
    public IChartBuilder setSeriesStroke(int series, Stroke stroke) {
        renderer.setSeriesStroke(0, stroke);
        return this;
    }

    @Override
    public IChartBuilder setOutlinePaint(Paint paint) {
        this.outlinePaint = paint;
        return this;
    }

    @Override
    public IChartBuilder setOutlineStroke(Stroke stroke) {
        this.outlineStroke = stroke;
        return this;
    }

    @Override
    public IChartBuilder setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;

        return this;
    }

    @Override
    public IChartBuilder setRangeGridlinesVisible(boolean visible) {
        this.rangeGridlinesVisible = visible;
        return this;
    }

    @Override
    public IChartBuilder setRangeGridlinePaint(Paint paint) {
        this.rangeGridlinePaint = paint;
        return this;
    }

    @Override
    public IChartBuilder setDomainGridlinesVisible(boolean visible) {
        this.domainGridlinesVisible = visible;
        return this;
    }

    @Override
    public IChartBuilder setDomainGridlinePaint(Paint paint) {
        this.domainGridlinePaint = paint;

        return this;
    }

}
