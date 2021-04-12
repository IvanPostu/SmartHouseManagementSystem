package com.ivan.app.l5;

import java.util.Base64;
import java.util.Base64.Encoder;

public class SSL2AlarmReporterDecorator extends BaseAlarmDecorator {

    public SSL2AlarmReporterDecorator(IAlarmReporterComponent component) {
        super(component);
    }

    @Override
    public void reportAlarm(StringBuilder alarmMessage) {
        alarmMessage.append(" (Encrypted with SSL2)");

        super.reportAlarm(alarmMessage);
    }

    public void executeExtraLogic() {

        Encoder encoder = Base64.getEncoder();
        String originalString = "basic";
        String encodedString = encoder.encodeToString(originalString.getBytes());

        System.out.println(encodedString);

    }

}
