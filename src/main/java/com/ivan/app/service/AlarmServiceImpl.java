package com.ivan.app.service;

import com.ivan.app.l5.AlarmReporterComponentsNetwork;
import com.ivan.app.l5.IAlarmReporterComponent;
import com.ivan.app.l5.SSL2AlarmReporterDecorator;
import com.ivan.app.l5.SSL3AlarmReporterDecorator;
import com.ivan.app.l5.SocketAlarmReporter;
import com.ivan.app.l5.TLSAlarmReporterDecorator;

public class AlarmServiceImpl implements AlarmService {

    private IAlarmReporterComponent alarmReporter;

    public AlarmServiceImpl() {
        this.alarmReporter = new AlarmReporterComponentsNetwork();
        initializeAlarmReporter();
    }

    private void initializeAlarmReporter() {

        AlarmReporterComponentsNetwork policeAlarmNetwork = new AlarmReporterComponentsNetwork();

        policeAlarmNetwork.addComponent(
                new TLSAlarmReporterDecorator(new SSL3AlarmReporterDecorator(new SSL2AlarmReporterDecorator(
                        new SocketAlarmReporter("www.police-department-1.com", "secret-token1")))));

        policeAlarmNetwork.addComponent(
                new SSL2AlarmReporterDecorator(new SSL3AlarmReporterDecorator(new TLSAlarmReporterDecorator(
                        new SocketAlarmReporter("www.police-department-2.com", "secret-token2")))));

        AlarmReporterComponentsNetwork fireDepartmentAlarmNetwork = new AlarmReporterComponentsNetwork();

        fireDepartmentAlarmNetwork.addComponent(new TLSAlarmReporterDecorator(
                new SSL2AlarmReporterDecorator(new SocketAlarmReporter("www.fire-department-1.com", "secret-token1"))));

        fireDepartmentAlarmNetwork.addComponent(new SSL2AlarmReporterDecorator(
                new SSL3AlarmReporterDecorator(new SocketAlarmReporter("www.fire-department-2.com", "secret-token2"))));

        AlarmReporterComponentsNetwork ambulanceAlarmNetwork = new AlarmReporterComponentsNetwork();
        ambulanceAlarmNetwork.addComponent(new TLSAlarmReporterDecorator(new SSL3AlarmReporterDecorator(
                new SSL2AlarmReporterDecorator(new SocketAlarmReporter("www.ambulance.com", "secret-token1")))));

        AlarmReporterComponentsNetwork instanceAlarmReporter = new AlarmReporterComponentsNetwork();
        instanceAlarmReporter.addComponent(policeAlarmNetwork);
        instanceAlarmReporter.addComponent(fireDepartmentAlarmNetwork);
        instanceAlarmReporter.addComponent(ambulanceAlarmNetwork);
        this.alarmReporter = instanceAlarmReporter;
    }

    @Override
    public void sendAlarmToServer(String alarmMessage) {
        alarmReporter.reportAlarm(new StringBuilder(alarmMessage));
    }

}
