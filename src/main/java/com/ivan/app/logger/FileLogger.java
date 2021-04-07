package com.ivan.app.logger;

/**
 *
 * @author ivan
 */
public class FileLogger implements ILogger {

    private String targetClassName;
    private LogResolverPrototype logResolverPrototype;

    public FileLogger(String targetClassName, LogResolverPrototype logResolverPrototype) {
        this.targetClassName = targetClassName;
        this.logResolverPrototype = logResolverPrototype;
    }
    
    @Override
    public void debug(String msg) {
    }

    @Override
    public void info(String msg) {
    }

    @Override
    public void warn(String msg) {
    }

    @Override
    public void error(String msg) {
    }

    @Override
    public String getClassTargetName() {
        return "";
    }
    
}
