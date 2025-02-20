/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import javax.swing.JMenu;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author User
 */
public final class MainWindow extends javax.swing.JFrame {

    private static MainWindow singleton;
    private static final Logger LOGGER = LogManager.getLogger(MainWindow.class);
    
    private MainWindow() {
        initComponents();
        getProfileMenu().setVisible(false);

        setTitle("Smart House Management System");
        LOGGER.info("MainMenu successfully created");
    }

    public static synchronized MainWindow getInstance() {
        if (singleton == null) {
            singleton = new MainWindow();
            singleton.setLocationRelativeTo(null);
            singleton.setContentPane(new SignInScreen());
            singleton.setVisible(true);
        }

        return singleton;
    }

    public JMenu getProfileMenu() {
        return profileMenu;
    }

    public void setContent(JPanel panel) {
        this.getContentPane().removeAll();
        this.setContentPane(panel);
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        profileMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        signOutMenuItem = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        profileMenu.setText("Profile");

        jMenuItem2.setText("Info");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        profileMenu.add(jMenuItem2);

        jMenuItem3.setText("Menu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        profileMenu.add(jMenuItem3);

        signOutMenuItem.setText("Sign out");
        signOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutMenuItemActionPerformed(evt);
            }
        });
        profileMenu.add(signOutMenuItem);

        jMenuBar1.add(profileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutMenuItemActionPerformed
        profileMenu.setVisible(false);
        this.setContentPane(new SignInScreen());
        this.revalidate();
    }//GEN-LAST:event_signOutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        setContent(new HomeScreen());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu profileMenu;
    private javax.swing.JMenuItem signOutMenuItem;
    // End of variables declaration//GEN-END:variables
}
