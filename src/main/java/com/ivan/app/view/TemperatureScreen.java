/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
        initLineChartPanel();
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

    private void initLineChartPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Java";
        String series2 = "PHP";
        String series3 = "C++";
        String series4 = "C#";

        dataset.addValue(5.0, series1, "2005");
        dataset.addValue(4.8, series1, "2006");
        dataset.addValue(4.5, series1, "2007");
        dataset.addValue(4.3, series1, "2008");
        dataset.addValue(4.0, series1, "2009");
        dataset.addValue(4.1, series1, "2010");
        dataset.addValue(4.2, series1, "2011");
        dataset.addValue(4.2, series1, "2012");
        dataset.addValue(4.0, series1, "2013");

        dataset.addValue(4.0, series2, "2005");
        dataset.addValue(4.2, series2, "2006");
        dataset.addValue(3.8, series2, "2007");
        dataset.addValue(3.6, series2, "2008");
        dataset.addValue(3.4, series2, "2009");
        dataset.addValue(3.4, series2, "2010");
        dataset.addValue(3.3, series2, "2011");
        dataset.addValue(3.1, series2, "2012");
        dataset.addValue(3.2, series2, "2013");

        dataset.addValue(3.6, series3, "2005");
        dataset.addValue(3.4, series3, "2006");
        dataset.addValue(3.5, series3, "2007");
        dataset.addValue(3.2, series3, "2008");
        dataset.addValue(3.2, series3, "2009");
        dataset.addValue(3.0, series3, "2010");
        dataset.addValue(2.8, series3, "2011");
        dataset.addValue(2.8, series3, "2012");
        dataset.addValue(2.6, series3, "2013");

        dataset.addValue(3.2, series4, "2005");
        dataset.addValue(3.2, series4, "2006");
        dataset.addValue(3.0, series4, "2007");
        dataset.addValue(3.0, series4, "2008");
        dataset.addValue(2.8, series4, "2009");
        dataset.addValue(2.7, series4, "2010");
        dataset.addValue(2.6, series4, "2011");
        dataset.addValue(2.6, series4, "2012");
        dataset.addValue(2.4, series4, "2013");

        String chartTitle = "Programming Languages Trends";
        String categoryAxisLabel = "Interest over time";
        String valueAxisLabel = "Popularity";

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesPaint(3, Color.YELLOW);

        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(1.5f));

        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(2.0f));
        plot.setBackgroundPaint(Color.CYAN);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.setRenderer(renderer);

        lineChartPanel.removeAll();
        lineChartPanel.add(chartPanel, BorderLayout.CENTER);
        lineChartPanel.validate();

//        File imageFile = new File("LineChart.png");
//        int width = 640;
//        int height = 480;
//
//        try {
//            ChartUtils.saveChartAsPNG(imageFile, chart, width, height);
//        } catch (IOException ex) {
//            System.err.println(ex);
//        }
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
        lineChartPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 1100));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 1500));

        jPanel2.setBackground(java.awt.SystemColor.controlHighlight);
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

        lineChartPanel.setBackground(new java.awt.Color(204, 255, 204));
        lineChartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelChart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(browsersPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartBarColorsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(lineChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
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
    private javax.swing.JPanel lineChartPanel;
    private javax.swing.JPanel panelChart;
    // End of variables declaration//GEN-END:variables
}
