/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.crypto;

/**
 *
 * @author ivan
 */
public class Base64Resolver implements Base64Encoder, Base64Decoder {

    @Override
    public String bytesToBase64Hex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public byte[] base64HexToBytes(String s) {
        String[] strBytes = s.split("(?<=\\G.{2})");
        byte[] bytes = new byte[strBytes.length];
        for (int i = 0; i < strBytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(strBytes[i], 16);
        }
        return bytes;
    }

}
