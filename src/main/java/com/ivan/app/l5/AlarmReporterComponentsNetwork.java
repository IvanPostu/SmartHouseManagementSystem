package com.ivan.app.l5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AlarmReporterComponentsNetwork implements IAlarmReporterComponent {

    private final List<IAlarmReporterComponent> reporters;

    public AlarmReporterComponentsNetwork() {
        this.reporters = new ArrayList<>();
    }

    @Override
    public void reportAlarm(StringBuilder alarmMessage) {

        Consumer<IAlarmReporterComponent> forEachCallback = (s) -> {
            s.reportAlarm(new StringBuilder(alarmMessage));
        };

        this.reporters.forEach(forEachCallback);
    }

    public List<IAlarmReporterComponent> getReporters() {
        return reporters;
    }

    public void addComponent(IAlarmReporterComponent component) {
        reporters.add(component);
    }

    public void removeComponent(IAlarmReporterComponent component) {
        reporters.remove(component);
    }

}
