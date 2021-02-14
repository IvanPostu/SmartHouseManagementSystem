/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ivan
 */
public class HumidityScreen extends javax.swing.JPanel {

    /**
     * Creates new form HumidityScreen
     */
    public HumidityScreen() {
        initComponents();

        this.insideHotRealtimeHumidityDataset = new DefaultCategoryDataset();
        this.outsideHotRealtimeHumidityDataset = new DefaultCategoryDataset();
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(18);
        
        initInsideRealtimeHumidityDiagram();
        initOutsideRealtimeHumidityDiagram();
        
        this.hotDiagramUpdateTimer = new Timer(1000 * 2, (e) -> {
            updateHumidityInsideTheHouseValue();
            updateHumidityOutsideTheHouseValue();
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();
        this.hotDiagramUpdateTimer.start();
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        this.hotDiagramUpdateTimer.stop();
    }

    private void updateHumidityInsideTheHouseValue() {
        Random random = new Random();
        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND)));
        String dateStr = dateTimeFormatter.format(calendar.getTime());
        insideHotRealtimeHumidityDataset.addValue(25 + random.nextInt(15), "humidity",
                dateStr);
        insideHotRealtimeHumidityDataset.removeColumn(0);
    }

    private void updateHumidityOutsideTheHouseValue() {
        Random random = new Random();
        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND)));
        String dateStr = dateTimeFormatter.format(calendar.getTime());
        outsideHotRealtimeHumidityDataset.addValue(35 + random.nextInt(20), "humidity",
                dateStr);
        outsideHotRealtimeHumidityDataset.removeColumn(0);
    }

    // <editor-fold defaultstate="collapsed" desc="initInsideRealtimeHumidityDiagram">  
    private void initInsideRealtimeHumidityDiagram() {

        String series1 = "humidity";

        Random random = new Random();

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String dateStr = "";

        DefaultCategoryDataset dataset = insideHotRealtimeHumidityDataset;
        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 9; i++) {
            calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND) - 2));
            dateStr = dateTimeFormatter.format(calendar.getTime());
            dataset.addValue(25 + random.nextInt(12), series1, dateStr);
        }

        String chartTitle = "Humidity (inside the house)";
        String categoryAxisLabel = "Time";
        String valueAxisLabel = "Relative humidity (%)";

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 100);
        rangeAxis.setTickUnit(new NumberTickUnit(5.0));

        renderer.setSeriesPaint(0, Color.RED);

        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(1.5f));

        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(1.0f));
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.setRenderer(renderer);

        insideHouseHumidityDiagramPanel.removeAll();
        insideHouseHumidityDiagramPanel.add(chartPanel, BorderLayout.CENTER);
        insideHouseHumidityDiagramPanel.validate();

    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="initOutsideRealtimeHumidityDiagram">  
    private void initOutsideRealtimeHumidityDiagram() {

        String series1 = "humidity";

        Random random = new Random();

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String dateStr;

        DefaultCategoryDataset dataset = outsideHotRealtimeHumidityDataset;
        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 9; i++) {
            calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND) - 2));
            dateStr = dateTimeFormatter.format(calendar.getTime());
            dataset.addValue(25 + random.nextInt(12), series1, dateStr);
        }

        String chartTitle = "Humidity (outside the house)";
        String categoryAxisLabel = "Time";
        String valueAxisLabel = "Relative humidity (%)";

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 100);
        rangeAxis.setTickUnit(new NumberTickUnit(5.0));

        renderer.setSeriesPaint(0, Color.RED);

        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(1.5f));

        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(1.0f));
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.setRenderer(renderer);

        outsideHouseHumidityDiagramPanel.removeAll();
        outsideHouseHumidityDiagramPanel.add(chartPanel, BorderLayout.CENTER);
        outsideHouseHumidityDiagramPanel.validate();

    }
    // </editor-fold> 

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
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        realtimeHumidityInsideTheHousePanel = new javax.swing.JPanel();
        insideHouseHumidityDiagramPanel = new javax.swing.JPanel();
        realtimeHumidityOutsideTheHousePanel = new javax.swing.JPanel();
        outsideHouseHumidityDiagramPanel = new javax.swing.JPanel();

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

        titlePanel.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("House humidity in %");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        realtimeHumidityInsideTheHousePanel.setPreferredSize(new java.awt.Dimension(0, 400));

        insideHouseHumidityDiagramPanel.setBackground(new java.awt.Color(51, 51, 51));
        insideHouseHumidityDiagramPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout realtimeHumidityInsideTheHousePanelLayout = new javax.swing.GroupLayout(realtimeHumidityInsideTheHousePanel);
        realtimeHumidityInsideTheHousePanel.setLayout(realtimeHumidityInsideTheHousePanelLayout);
        realtimeHumidityInsideTheHousePanelLayout.setHorizontalGroup(
            realtimeHumidityInsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(insideHouseHumidityDiagramPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        realtimeHumidityInsideTheHousePanelLayout.setVerticalGroup(
            realtimeHumidityInsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(realtimeHumidityInsideTheHousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insideHouseHumidityDiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        realtimeHumidityOutsideTheHousePanel.setPreferredSize(new java.awt.Dimension(0, 400));

        outsideHouseHumidityDiagramPanel.setBackground(new java.awt.Color(51, 51, 51));
        outsideHouseHumidityDiagramPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout realtimeHumidityOutsideTheHousePanelLayout = new javax.swing.GroupLayout(realtimeHumidityOutsideTheHousePanel);
        realtimeHumidityOutsideTheHousePanel.setLayout(realtimeHumidityOutsideTheHousePanelLayout);
        realtimeHumidityOutsideTheHousePanelLayout.setHorizontalGroup(
            realtimeHumidityOutsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outsideHouseHumidityDiagramPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        realtimeHumidityOutsideTheHousePanelLayout.setVerticalGroup(
            realtimeHumidityOutsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(realtimeHumidityOutsideTheHousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outsideHouseHumidityDiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(realtimeHumidityOutsideTheHousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(realtimeHumidityInsideTheHousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(realtimeHumidityInsideTheHousePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(realtimeHumidityOutsideTheHousePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel insideHouseHumidityDiagramPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel outsideHouseHumidityDiagramPanel;
    private javax.swing.JPanel realtimeHumidityInsideTheHousePanel;
    private javax.swing.JPanel realtimeHumidityOutsideTheHousePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

    private Timer hotDiagramUpdateTimer;
    private DefaultCategoryDataset insideHotRealtimeHumidityDataset;
    private DefaultCategoryDataset outsideHotRealtimeHumidityDataset;

}
