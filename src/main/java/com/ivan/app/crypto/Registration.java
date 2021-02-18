/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.crypto;

import java.util.Scanner;

/**
 *
 * @author ivan
 */
public class Registration {

    public void registrateUser() {

        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        Difficulty difficulty = Difficulty.difficultyCreate(password.length());
        MainPlus.PasswordManager manager = new MainPlus
                .PasswordManager(difficulty.getHashFunction());
        byte[] encodedHash = manager.encryptPassword(password.getBytes());

        System.out.println(new Base64Resolver().bytesToBase64Hex(encodedHash));

    }

}
