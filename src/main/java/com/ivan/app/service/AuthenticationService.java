package com.ivan.app.service;

/**
 *
 * @author ivan
 */
public interface AuthenticationService {
    
    void authenticateUser(String username, String passwordHash);
    
}
