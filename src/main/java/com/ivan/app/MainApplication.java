package com.ivan.app;

import com.ivan.app.logger.LoggerConfigurator;
import com.ivan.app.view.MainWindow;


public class MainApplication {
   
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.getInstance();
                
            }
        });
    }
    
}
