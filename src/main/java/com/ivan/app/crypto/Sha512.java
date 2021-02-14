/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ivan
 */
public class Sha512 implements HashFunction {

    @Override
    public byte[] encode(byte[] plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashFunctionName());
            byte[] bytes = md.digest(plainText);
            
            return bytes;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String hashFunctionName() {
        return "SHA-512";
    }

}
