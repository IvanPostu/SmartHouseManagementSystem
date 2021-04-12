package com.ivan.app.l5;

import java.util.Base64;
import java.util.Base64.Encoder;

public class TLSAlarmReporterDecorator extends BaseAlarmDecorator {

    public TLSAlarmReporterDecorator(IAlarmReporterComponent component) {
        super(component);
    }

    @Override
    public void reportAlarm(StringBuilder alarmMessage) {
        // System.out.println("Encrypt using Transfer Layer Security");
        alarmMessage.append(" (Encrypted with tls1.3)");

        super.reportAlarm(alarmMessage);
    }

    public void executeExtraLogic() {

        Encoder encoder = Base64.getEncoder();
        String originalString = "basic";
        String encodedString = encoder.encodeToString(originalString.getBytes());

        System.out.println(encodedString);

    }

}
