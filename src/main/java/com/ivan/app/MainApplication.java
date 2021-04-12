package com.ivan.app;

import com.ivan.app.configurations.Log4jConfiguration;
import com.ivan.app.view.MainWindow;

public class MainApplication {

    static {
        Log4jConfiguration.configure();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(MainWindow::getInstance);
    }

}
