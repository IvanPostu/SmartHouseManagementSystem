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
public abstract class AbstractLoggerFactory {
    
    private static LogResolverPrototype prototype;
    
    public static ILogger createLogger(Class<?> tClass){
        if(prototype == null){
            prototype = LoggerConfigurator.getConfiguration();
        }
        
        return new StdOutLogger(tClass.getName(), prototype.getClone());
    }

}
