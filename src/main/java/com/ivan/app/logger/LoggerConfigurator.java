package com.ivan.app.logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author ivan
 */
public abstract class LoggerConfigurator {

    public static enum LogType {
        STDOUT, FILE
    };

    public static LogResolverPrototype getConfiguration() {
        return configurate();
    }

    private static LogResolverPrototype configurate() {
        byte[] buffer = new byte[256];
        InputStream in = LoggerConfigurator.class.getResourceAsStream("/logger-config.txt");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int nRead;

        String config = "";

        try {
            while ((nRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, nRead);
            }

            config = new String(out.toByteArray());
            out.flush();

        } catch (IOException ex) {
            System.out.println("LoggerConfigurator - configurate() ERROR");
        }

        String[] keyValConfig = config.split("\n");
        LogResolverPrototype result = new LogResolverPrototype();

        for (String s : keyValConfig) {
            String[] values = s.split("=");
            String key = values[0];
            String value = values[1];

            if (key.equals("logPattern")) {
                result.setLogPattern(value);
            }

            if (key.equals("logType")) {
                if (value.equals(LogType.STDOUT.toString())) {
                    result.setLogType(LogType.STDOUT);
                } else {
                    result.setLogType(LogType.FILE);
                }
            }
        }

        return result;
    }

}
