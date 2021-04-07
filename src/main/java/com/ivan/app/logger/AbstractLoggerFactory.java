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
public abstract class AbstractLoggerFactory<T extends ILogger> {

    private static LogResolverPrototype logResolverPrototype;

    public LogResolverPrototype getLogResolverPrototype() {
        if (logResolverPrototype == null) {
            logResolverPrototype = LoggerConfigurator.getConfiguration();
        }

        return logResolverPrototype.getClone();
    }

    public abstract T create(Class<?> tClass);

}
