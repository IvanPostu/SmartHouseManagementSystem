
package com.ivan.app.service;

import com.ivan.app.configurations.SQLiteConnectionWrapper;
import com.ivan.app.crypto.Base64Resolver;
import com.ivan.app.crypto.HashFunction;
import com.ivan.app.crypto.Sha256;
import com.ivan.app.datasource.UserDao;
import com.ivan.app.datasource.entity.UserEntity;
import com.ivan.app.datasource.sqlite.UserDaoImpl;
import com.ivan.app.view.HomeScreen;
import com.ivan.app.view.MainWindow;
import com.ivan.app.view.SignInScreen;
import java.nio.charset.StandardCharsets;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import com.ivan.app.crypto.Base64Encoder;


public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDao userDao;
    private final MainWindow mainWindow;
    private final HashFunction passwordEncoder;
    private final Base64Encoder base64Encoder;

    public AuthenticationServiceImpl() {
        SQLiteConnectionWrapper dbConnectionWrapper = SQLiteConnectionWrapper
                .getInstance();

        this.userDao = new UserDaoImpl(dbConnectionWrapper.getConnection());
        this.mainWindow = MainWindow.getInstance();
        this.passwordEncoder = new Sha256();
        this.base64Encoder = new Base64Resolver();
    }

    @Override
    public void authenticateUser(String username, String passwordHash) {

        final byte[] password = passwordHash.getBytes(StandardCharsets.UTF_8);
        final byte[] encryptedPassword = passwordEncoder.encode(password);
        final String passwordBase64Hash = base64Encoder
                .bytesToBase64Hex(encryptedPassword).toUpperCase();
        UserEntity user = userDao.selectUserByUsername(username).orElse(null);

        boolean successSignIn = user != null
                && user.getPassword() != null
                && passwordBase64Hash.equals(user.getPassword());

        if (successSignIn) {
            String successMessage = String.format("Wellcome %s %s", 
                    user.getFirstName(), user.getLastName());
            JOptionPane.showMessageDialog(
                    MainWindow.getInstance(), successMessage, "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            mainWindow.setContent(new HomeScreen());
            JMenu profileMenu = mainWindow.getProfileMenu();
            profileMenu.setVisible(true);
        } else {
            String message = "Username or password is incorrect !!!";
            JOptionPane.showMessageDialog(
                    MainWindow.getInstance(), message, "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            mainWindow.setContent(new SignInScreen());
        }
    }

}
