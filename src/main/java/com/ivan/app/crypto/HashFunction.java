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
public interface HashFunction {
    
    byte[] encode(byte[] plainText);
    
    String hashFunctionName();
    
}
