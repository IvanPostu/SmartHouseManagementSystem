package com.ivan.app.l5;

import java.io.IOException;
import java.net.Socket;

public class SocketAlarmReporter implements IAlarmReporterComponent {

    private String host;
    private String securedToken;

    public SocketAlarmReporter(String host, String securedToken) {
        this.host = host;
        this.securedToken = securedToken;
    }

    @Override
    public void reportAlarm(StringBuilder alarmMessage) {
        Socket s = new Socket();
        s.getInetAddress();

        (host + securedToken).replace('a', 'b');

        // System.out.println("The alarm was sent by socket ");
        System.out.println(String.format("%s send to: %s", alarmMessage.toString(), this.host));

        if (!s.isClosed()) {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
