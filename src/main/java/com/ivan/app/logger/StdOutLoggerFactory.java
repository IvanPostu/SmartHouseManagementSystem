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
public class StdOutLoggerFactory extends AbstractLoggerFactory<StdOutLogger> {

    @Override
    public StdOutLogger create(Class<?> tClass) {
        return new StdOutLogger(tClass.getName(), super.getLogResolverPrototype());
    }
    
}
