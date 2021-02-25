/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.logger;

/**
 *
 * @author ivan
 */
public interface ILogger {
    
    String getClassTargetName();
    
    void debug(String msg);
    
    void info(String msg);
    
    void warn(String msg);
    
    void error(String msg);
    
}
