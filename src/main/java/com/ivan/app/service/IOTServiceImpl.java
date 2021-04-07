package com.ivan.app.service;

import com.ivan.app.iot.RadexF3;
import com.ivan.app.iot.RadexRD1008;
import com.ivan.app.iot.RadiationDosimiterNetwork;
import com.ivan.app.iot.builder.RadexF3Builder;
import com.ivan.app.iot.builder.RadexRD1008Builder;
import com.ivan.app.iot.builder.RadiationDosimeterDirector;
import com.ivan.app.iot.builder.RadiationDosimiterBuilder;

public class IOTServiceImpl implements IOTService {

    private RadiationDosimiterNetwork radiationDosimetersOnTheTerritoryOfTheHouse;

    public IOTServiceImpl() {
        this.radiationDosimetersOnTheTerritoryOfTheHouse = new RadiationDosimiterNetwork();
        installRadiationDozimetersOnHomeTerritory();
    }

    private void installRadiationDozimetersOnHomeTerritory() {
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

        this.radiationDosimetersOnTheTerritoryOfTheHouse.add(network);

        RadiationDosimiterNetwork network1 = new RadiationDosimiterNetwork();
        RadiationDosimiterNetwork network2 = new RadiationDosimiterNetwork();

        network1.add(firstBuilder.getResult());
        network1.add(firstBuilder.getResult());
        network1.add(secondBuilder.getResult());

        network2.add(firstBuilder.getResult());
        network2.add(secondBuilder.getResult());

        network2.add(network1);
        radiationDosimetersOnTheTerritoryOfTheHouse.add(network2);

        radiationDosimetersOnTheTerritoryOfTheHouse.add(firstBuilder.getResult());
        radiationDosimetersOnTheTerritoryOfTheHouse.add(firstBuilder.getResult());
        radiationDosimetersOnTheTerritoryOfTheHouse.add(secondBuilder.getResult());
        radiationDosimetersOnTheTerritoryOfTheHouse.add(secondBuilder.getResult());

    }

    @Override
    public double radiationLevelOutsideTheHouse() {
        return 0;
    }

    @Override
    public double radiationLevelInsideTheHouse() {
        return 0;
    }

}
