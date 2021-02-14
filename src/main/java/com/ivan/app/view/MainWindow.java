/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.view;

import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public final class MainWindow extends javax.swing.JFrame {

    
    private static MainWindow singleton;
    
    private MainWindow() {
        initComponents();
        getProfileMenu().setVisible(false);
        
        setTitle("Smart House Management System");
    }

    public static synchronized MainWindow getInstance(){
        if(singleton == null) {
            singleton = new MainWindow();
        }
        
        return singleton;
    }

    public JMenu getProfileMenu() {
        return profileMenu;
    }
    
    public void setContent(JPanel panel){
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
        profileMenu.add(jMenuItem2);

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
    private javax.swing.JMenu profileMenu;
    private javax.swing.JMenuItem signOutMenuItem;
    // End of variables declaration//GEN-END:variables
}
