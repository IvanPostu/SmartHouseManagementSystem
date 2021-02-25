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
class StdOutLogger implements ILogger {

    private String targetClassName;
    private LogResolverPrototype logResolverPrototype;

    public StdOutLogger(String targetClassName, LogResolverPrototype logResolverPrototype) {
        this.targetClassName = targetClassName;
        this.logResolverPrototype = logResolverPrototype;
    }

    private void print(String msg, String level) {

        logResolverPrototype.setText(msg, targetClassName, level);
        String message = logResolverPrototype.getLogMessage();
        
        System.out.println(message);

    }

    @Override
    public void debug(String msg) {
        print(msg, "DEBUG");
    }

    @Override
    public void info(String msg) {
        print(msg, "INFO");

    }

    @Override
    public void warn(String msg) {
        print(msg, "WARN");

    }

    @Override
    public void error(String msg) {
        print(msg, "ERROR");

    }

    @Override
    public String getClassTargetName() {
        return targetClassName;
    }

}
