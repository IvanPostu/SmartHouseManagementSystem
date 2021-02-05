/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ivan
 */
public class TemperatureScreen extends javax.swing.JPanel {

    /**
     * Creates new form TemperatureScreen
     */
    public TemperatureScreen() {
        initComponents();

        initBrowsersChart();
        initChart();
        initScatterChartPanel();
        initChartBarsColorPanel();
    }

    private void initChart() {
        DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();
        barChartDataset.setValue(20000, "Contribution amount", "January");
        barChartDataset.setValue(15000, "Contribution amount", "February");
        barChartDataset.setValue(30000, "Contribution amount", "March");

        JFreeChart barChart = ChartFactory
                .createBarChart("Church Contributions",
                        "Monthly",
                        "Contribution Amount",
                        barChartDataset,
                        PlotOrientation.VERTICAL,
                        false,
                        true,
                        false);

        CategoryPlot categoryPlog = barChart.getCategoryPlot();
        categoryPlog.setRangeGridlinePaint(Color.ORANGE);

        ChartPanel chartPanel = new ChartPanel(barChart);

        panelChart.removeAll();
        panelChart.add(chartPanel, BorderLayout.CENTER);
        panelChart.validate();

    }

    private void initBrowsersChart() {
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue("Chrome", 29);
        dataSet.setValue("InternetExplorer", 36);
        dataSet.setValue("Firefox", 35);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createPieChart3D("Abcd", dataSet, true, true, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);

        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        browsersPanel.removeAll();
        browsersPanel.add(chartPanel, BorderLayout.CENTER);
        browsersPanel.validate();
    }

    private void initScatterChartPanel() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series1 = new XYSeries("Boys");
        series1.add(1, 72.9);
        series1.add(2, 81.6);
        series1.add(3, 88.9);
        series1.add(4, 96);
        series1.add(5, 102.1);
        series1.add(6, 108.5);
        series1.add(7, 113.9);
        series1.add(8, 119.3);
        series1.add(9, 123.8);
        series1.add(10, 124.4);

        XYSeries series2 = new XYSeries("Girls");
        series2.add(1, 52.5);
        series2.add(2, 70.1);
        series2.add(3, 83.2);
        series2.add(4, 91.5);
        series2.add(5, 111.4);
        series2.add(6, 102.4);
        series2.add(7, 110.8);
        series2.add(8, 113.2);
        series2.add(9, 120.9);
        series2.add(10, 111.4);

        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.
                createScatterPlot("Boys VS Girls weight "
                        + "comparison chart",
                        "X-Axis",
                        "Y-Axis",
                        dataset);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(25, 228, 196));

        ChartPanel chartPanel = new ChartPanel(chart);

        jPanel3.removeAll();
        jPanel3.add(chartPanel, BorderLayout.CENTER);
        jPanel3.validate();

    }

    private void initChartBarsColorPanel() {
        String title = "Bar chart Color Example";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1, "Student heights", "Less than 130");
        dataset.addValue(20, "Student heights", "130 to 134");
        dataset.addValue(30, "Student heights", "135 to 139");
        dataset.addValue(16, "Student heights", "140 to 144");
        dataset.addValue(9, "Student heights", "144 to 148");

        dataset.addValue(4, "Teacher heights", "Less than 130");
        dataset.addValue(3, "Teacher heights", "130 to 134");
        dataset.addValue(10, "Teacher heights", "135 to 139");
        dataset.addValue(5, "Teacher heights", "140 to 144");
        dataset.addValue(1, "Teacher heights", "144 to 148");

        /* create chart */
        JFreeChart chart = ChartFactory.createBarChart(title, "heights", "Number Of Persons", dataset);

        /* Get instance of CategoryPlot */
        CategoryPlot plot = chart.getCategoryPlot();

        /* Change Bar colors */
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.green);
        renderer.setSeriesPaint(2, Color.blue);

        renderer.setDrawBarOutline(false);
        renderer.setItemMargin(0);

        ChartPanel chartPanel = new ChartPanel(chart);

        chartBarColorsPanel.removeAll();
        chartBarColorsPanel.add(chartPanel, BorderLayout.CENTER);
        chartBarColorsPanel.validate();
        /* create and display chart on frame */
//        ChartFrame frame = new ChartFrame("JFreeChart Demo", chart);
//        frame.setVisible(true);
//        frame.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        browsersPanel = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        chartBarColorsPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 1100));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 1100));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 950));

        browsersPanel.setBackground(new java.awt.Color(255, 255, 51));
        browsersPanel.setLayout(new java.awt.BorderLayout());

        panelChart.setBackground(new java.awt.Color(255, 255, 51));
        panelChart.setLayout(new java.awt.BorderLayout());

        chartBarColorsPanel.setBackground(new java.awt.Color(255, 204, 204));
        chartBarColorsPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(browsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartBarColorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chartBarColorsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel browsersPanel;
    private javax.swing.JPanel chartBarColorsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelChart;
    // End of variables declaration//GEN-END:variables
}
