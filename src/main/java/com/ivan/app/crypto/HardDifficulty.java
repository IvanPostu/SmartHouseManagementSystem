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
public class HardDifficulty implements Difficulty{

    @Override
    public HashFunction getHashFunction() {
        return new Sha512();
    }
    
}
