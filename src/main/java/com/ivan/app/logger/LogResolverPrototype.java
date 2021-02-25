package com.ivan.app.logger;

/**
 *
 * @author ivan
 */
public class LogResolverPrototype implements Cloneable {

    private String logPattern;
    private String solvedText = "";
    private LoggerConfigurator.LogType logType;

    public LogResolverPrototype getClone() {
        try {
            return (LogResolverPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(" Cloning not allowed. ");
            return this;
        }
    }

    public void setLogPattern(String logPattern) {
        this.logPattern = logPattern;
    }

    public String getLogPattern() {
        return logPattern;
    }


    public void setText(String message, String targetClassName, String logLevel){
        this.solvedText = getLogPattern()
                .replace("{level}", logLevel)
                .replace("{message}", message)
                .replace("{targetClass}", targetClassName);
    }
    
    public String getLogMessage(){
        return this.solvedText;
    }

    public LoggerConfigurator.LogType getLogType() {
        return logType;
    }

    public void setLogType(LoggerConfigurator.LogType logType) {
        this.logType = logType;
    }
    
    
}
