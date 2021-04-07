/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import com.ivan.app.service.IOTService;
import com.ivan.app.service.IOTServiceImpl;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ivan
 */
public class RadiationBackgroundScreen extends javax.swing.JPanel {

    private final Timer hotDiagramUpdateTimer;
    private final DefaultCategoryDataset hotRealtimeHumidityDataset;
    private final Random random;
    private final IOTService iOTService;
    private final String series1 = "Radiation background inside ( mZv/h )";
    private final String series2 = "Radiation background outside ( mZv/h )";

    public RadiationBackgroundScreen() {
        initComponents();

        this.iOTService = new IOTServiceImpl();
        this.random = new Random();
        this.hotRealtimeHumidityDataset = new DefaultCategoryDataset();
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(18);

        initHotRealtimeRadiationBackgroundDiagram();

        this.hotDiagramUpdateTimer = new Timer(1000 * 2, (e) -> {
            updateHotRealtimeRadiationBackgroundDiagram();
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

    private void updateHotRealtimeRadiationBackgroundDiagram() {

        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND)));
        String dateStr = dateTimeFormatter.format(calendar.getTime());
        
        double newValue = iOTService.radiationLevelInsideTheHouse();
        
        hotRealtimeHumidityDataset.addValue(newValue,
                "Radiation background inside ( mZv/h )",
                dateStr);
        newValue = iOTService.radiationLevelOutsideTheHouse();
        hotRealtimeHumidityDataset.addValue(newValue,
                "Radiation background outside ( mZv/h )",
                dateStr);
        hotRealtimeHumidityDataset.removeColumn(0);
    }

    // <editor-fold defaultstate="collapsed" desc="initHotRealtiveHumidityDiagram">  
    private void initHotRealtimeRadiationBackgroundDiagram() {

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String dateStr;

        DateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 9; i++) {
            calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND) - 2));
            dateStr = dateTimeFormatter.format(calendar.getTime());
            double newValue;
            newValue = iOTService.radiationLevelInsideTheHouse();
            hotRealtimeHumidityDataset.addValue(newValue, series1, dateStr);
            newValue = iOTService.radiationLevelOutsideTheHouse();
            hotRealtimeHumidityDataset.addValue(newValue, series2, dateStr);
        }

        String chartTitle = "Radiation background ( realtime diagram )";
        String categoryAxisLabel = "Time";
        String valueAxisLabel = "Radiation background";

        ILineChartBuilder chartBuilder = new LineChartBuilder();

        chartBuilder
                .setTitle(chartTitle)
                .setCategoryAxisLabel(categoryAxisLabel)
                .setValueAxisLabel(valueAxisLabel)
                .setCategoryDataset(hotRealtimeHumidityDataset)
                .setAxisRange(0, 10)
                .setTickUnit(new NumberTickUnit(1.0))
                .setSeriesPaint(0, Color.BLUE)
                .setSeriesStroke(0, new BasicStroke(2.0f))
                .setSeriesPaint(1, Color.GREEN)
                .setSeriesStroke(1, new BasicStroke(3.0f))
                .setOutlinePaint(Color.BLUE)
                .setOutlineStroke(new BasicStroke(2.0f))
                .setBackgroundPaint(Color.WHITE)
                .setRangeGridlinesVisible(true)
                .setRangeGridlinePaint(Color.BLACK)
                .setDomainGridlinesVisible(true)
                .setDomainGridlinePaint(Color.RED);

        IChart chart = chartBuilder.build();

        ChartPanel chartPanel = new ChartPanel(chart.getChart());

        hotHouseHumidityDiagramPanel.removeAll();
        hotHouseHumidityDiagramPanel.add(chartPanel, BorderLayout.CENTER);
        hotHouseHumidityDiagramPanel.validate();

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
        backButton = new javax.swing.JButton();
        realtimeHumidityInsideTheHousePanel = new javax.swing.JPanel();
        hotHouseHumidityDiagramPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 1100));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel2.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 950));
        jPanel2.setRequestFocusEnabled(false);

        titlePanel.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Radiation Background");

        backButton.setText("Back");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        realtimeHumidityInsideTheHousePanel.setPreferredSize(new java.awt.Dimension(0, 400));

        hotHouseHumidityDiagramPanel.setBackground(new java.awt.Color(51, 51, 51));
        hotHouseHumidityDiagramPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout realtimeHumidityInsideTheHousePanelLayout = new javax.swing.GroupLayout(realtimeHumidityInsideTheHousePanel);
        realtimeHumidityInsideTheHousePanel.setLayout(realtimeHumidityInsideTheHousePanelLayout);
        realtimeHumidityInsideTheHousePanelLayout.setHorizontalGroup(
            realtimeHumidityInsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hotHouseHumidityDiagramPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        realtimeHumidityInsideTheHousePanelLayout.setVerticalGroup(
            realtimeHumidityInsideTheHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(realtimeHumidityInsideTheHousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hotHouseHumidityDiagramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(realtimeHumidityInsideTheHousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(realtimeHumidityInsideTheHousePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainWindow.getInstance().setContent(new HomeScreen());
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel hotHouseHumidityDiagramPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel realtimeHumidityInsideTheHousePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}
