/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.service;

import com.ivan.app.configurations.SQLiteConnectionWrapper;
import com.ivan.app.datasource.UserDao;
import com.ivan.app.datasource.entity.UserEntity;
import com.ivan.app.datasource.sqlite.UserDaoImpl;
import com.ivan.app.view.HomeScreen;
import com.ivan.app.view.MainWindow;
import com.ivan.app.view.SignInScreen;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDao userDao;
    private final MainWindow mainWindow;

    public AuthenticationServiceImpl() {
        SQLiteConnectionWrapper dbConnectionWrapper = SQLiteConnectionWrapper.getInstance();
        userDao = new UserDaoImpl(dbConnectionWrapper.getConnection());
        mainWindow = MainWindow.getInstance();
    }

    @Override
    public void authenticateUser(String username, String passwordHash) {

        final char[] password = passwordHash.toCharArray();
        boolean successSignIn;
        UserEntity user = userDao.selectUserByUsername(username).orElse(null);

        successSignIn = user != null
                && user.getPassword() != null
                && new String(password).equals(user.getPassword());

        if (successSignIn) {
            String successMessage = String.format("Wellcome %s %s", user.getFirstName(), user.getLastName());
            JOptionPane.showMessageDialog(
                    MainWindow.getInstance(), successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
            mainWindow.setContent(new HomeScreen());
            JMenu profileMenu = mainWindow.getProfileMenu();
            profileMenu.setVisible(true);
        } else {
            String message = "Username or password is incorrect !!!";
            JOptionPane.showMessageDialog(
                    MainWindow.getInstance(), message, "Warning", JOptionPane.WARNING_MESSAGE);
            mainWindow.setContent(new SignInScreen());
        }
    }

}
