/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author ivan
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        byte[] encryptedPassword;

        if (password.length() < 5) {
            System.out.println("Complexitatea password - ului este scazuta,"
                    + " se v-a utiliza hash functie compusa.");
            try {
                final String hashFunctionName = "SHA-512";
                final MessageDigest digest = MessageDigest
                        .getInstance(hashFunctionName);
                byte[] encodedHash = digest.digest(password.getBytes());

                encryptedPassword = encodedHash;
                
                System.out.println(new Base64Resolver().bytesToBase64Hex(encodedHash));
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        } else if (password.length() >= 5) {
            System.out.println("Complexitatea password - ului este inalta,"
                    + " se v-a utiliza hash functie mai slaba.");

            try {
                final String hashFunctionName = "SHA-256";
                final MessageDigest digest = MessageDigest
                        .getInstance(hashFunctionName);
                byte[] encodedHash = digest.digest(password.getBytes());

                encryptedPassword = encodedHash;
                
                System.out.println(new Base64Resolver().bytesToBase64Hex(encodedHash));
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex.getMessage());
            }

        }

    }

}
