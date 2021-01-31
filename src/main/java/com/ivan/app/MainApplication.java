/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app;

import com.ivan.app.view.MainWindow;
import com.ivan.app.view.SignInScreen;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainWindow = MainWindow.getInstance();
                mainWindow.setLocationRelativeTo(null);
                mainWindow.setContentPane(new SignInScreen());
                mainWindow.setVisible(true);
            }
        });
    }
    
}
