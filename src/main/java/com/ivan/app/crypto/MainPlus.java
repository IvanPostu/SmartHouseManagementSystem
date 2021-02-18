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
public class MainPlus {

    static class PasswordManager {

        private HashFunction hashFunction;

        PasswordManager(HashFunction hashFunction) {
            this.hashFunction = hashFunction;
        }

        byte[] encryptPassword(byte[] passwordBytes) {
            return hashFunction.encode(passwordBytes);
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        byte[] encodedHash = new byte[1];

        if (password.length() < 5) {
            System.out.println("Complexitatea password - ului este scazuta,"
                    + " se v-a utiliza hash functie compusa.");

            PasswordManager manager = new PasswordManager(new Sha512());
            encodedHash = manager.encryptPassword(password.getBytes());

        } else if (password.length() >= 5) {
            System.out.println("Complexitatea password - ului este inalta,"
                    + " se v-a utiliza hash functie mai slaba.");

            PasswordManager manager = new PasswordManager(new Sha256());
            encodedHash = manager.encryptPassword(password.getBytes());

        }

        System.out.println(new Base64Resolver().bytesToBase64Hex(encodedHash));

    }

}
