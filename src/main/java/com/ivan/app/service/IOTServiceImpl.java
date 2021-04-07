package com.ivan.app.service;

import com.ivan.app.iot.RadexF3;
import com.ivan.app.iot.RadexRD1008;
import com.ivan.app.iot.RadiationDosimiterNetwork;
import com.ivan.app.iot.builder.RadexF3Builder;
import com.ivan.app.iot.builder.RadexRD1008Builder;
import com.ivan.app.iot.builder.RadiationDosimeterDirector;
import com.ivan.app.iot.builder.RadiationDosimiterBuilder;

public class IOTServiceImpl implements IOTService {

    private final RadiationDosimiterNetwork dosimeterTreeInsideTheHouse;
    private final RadiationDosimiterNetwork dosimeterTreeOutsideTheHouse;

    public IOTServiceImpl() {
        this.dosimeterTreeInsideTheHouse = new RadiationDosimiterNetwork();
        this.dosimeterTreeOutsideTheHouse = new RadiationDosimiterNetwork();

        installRadiationDozimetersInsideTheHouse();
        installRadiationDozimetersOutsideTheHouse();
    }

    private void installRadiationDozimetersOutsideTheHouse() {
        RadiationDosimiterBuilder<RadexF3> firstBuilder = new RadexF3Builder();
        RadiationDosimiterBuilder<RadexRD1008> secondBuilder = new RadexRD1008Builder();

        RadiationDosimeterDirector director = new RadiationDosimeterDirector(firstBuilder);
        director.make();
        director.changeBuilder(secondBuilder);
        director.make();

        RadiationDosimiterNetwork network = new RadiationDosimiterNetwork();
        network.add(firstBuilder.getResult());
        network.add(firstBuilder.getResult());
        network.add(secondBuilder.getResult());
        network.add(firstBuilder.getResult());

        this.dosimeterTreeOutsideTheHouse.add(network);

        RadiationDosimiterNetwork network1 = new RadiationDosimiterNetwork();
        RadiationDosimiterNetwork network2 = new RadiationDosimiterNetwork();

        network1.add(firstBuilder.getResult());
        network1.add(firstBuilder.getResult());
        network1.add(secondBuilder.getResult());

        network2.add(firstBuilder.getResult());
        network2.add(secondBuilder.getResult());

        network2.add(network1);
        dosimeterTreeOutsideTheHouse.add(network2);

        dosimeterTreeOutsideTheHouse.add(firstBuilder.getResult());
        dosimeterTreeOutsideTheHouse.add(firstBuilder.getResult());
        dosimeterTreeOutsideTheHouse.add(secondBuilder.getResult());
        dosimeterTreeOutsideTheHouse.add(secondBuilder.getResult());

    }

    private void installRadiationDozimetersInsideTheHouse() {
        RadiationDosimiterBuilder<RadexF3> firstBuilder = new RadexF3Builder();
        RadiationDosimiterBuilder<RadexRD1008> secondBuilder = new RadexRD1008Builder();

        RadiationDosimeterDirector director = new RadiationDosimeterDirector(firstBuilder);
        director.make();
        director.changeBuilder(secondBuilder);
        director.make();

        RadiationDosimiterNetwork network = new RadiationDosimiterNetwork();
        network.add(firstBuilder.getResult());
        network.add(firstBuilder.getResult());
        network.add(secondBuilder.getResult());
        network.add(firstBuilder.getResult());

        this.dosimeterTreeInsideTheHouse.add(network);

        RadiationDosimiterNetwork network1 = new RadiationDosimiterNetwork();
        RadiationDosimiterNetwork network2 = new RadiationDosimiterNetwork();

        network1.add(firstBuilder.getResult());
        network1.add(firstBuilder.getResult());
        network1.add(secondBuilder.getResult());

        network2.add(firstBuilder.getResult());
        network2.add(secondBuilder.getResult());

        network2.add(network1);
        dosimeterTreeInsideTheHouse.add(network2);

        dosimeterTreeInsideTheHouse.add(firstBuilder.getResult());
        dosimeterTreeInsideTheHouse.add(firstBuilder.getResult());
        dosimeterTreeInsideTheHouse.add(secondBuilder.getResult());
        dosimeterTreeInsideTheHouse.add(secondBuilder.getResult());

    }

    @Override
    public double radiationLevelOutsideTheHouse() {
        return dosimeterTreeOutsideTheHouse.calculateCurrentRadiationLevel();
    }

    @Override
    public double radiationLevelInsideTheHouse() {
        return dosimeterTreeInsideTheHouse.calculateCurrentRadiationLevel();
    }

}
