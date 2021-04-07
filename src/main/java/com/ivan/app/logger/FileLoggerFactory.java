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
public class FileLoggerFactory extends AbstractLoggerFactory<FileLogger> {

    @Override
    public FileLogger create(Class<?> tClass) {
        return new FileLogger(tClass.getName(), super.getLogResolverPrototype());
    }

    
}
