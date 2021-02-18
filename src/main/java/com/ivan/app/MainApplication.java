package com.ivan.app;

import com.ivan.app.view.MainWindow;
import com.ivan.app.view.SignInScreen;
import javax.swing.JFrame;


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
