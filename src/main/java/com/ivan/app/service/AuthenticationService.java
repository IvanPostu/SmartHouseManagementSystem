/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.service;

/**
 *
 * @author ivan
 */
public interface AuthenticationService {
    
    void authenticateUser(String username, String passwordHash);
    
}
