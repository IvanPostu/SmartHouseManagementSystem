package com.ivan.app.l5;

public class BaseAlarmDecorator implements IAlarmReporterComponent {

    private IAlarmReporterComponent component;

    public BaseAlarmDecorator(IAlarmReporterComponent component) {
        this.component = component;
    }

    @Override
    public void reportAlarm(StringBuilder alarmMessage) {
        component.reportAlarm(alarmMessage);
    }
}
