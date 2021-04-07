package com.ivan.app.iot;

import java.util.Random;

public class RadexRD1008 implements RadiationDosimiterComponent, Cloneable {

    private String radexRD1008UniqueKeyId;
    private byte[] radexRD1008ControllerMatrice;

    @Override
    public double calculateCurrentRadiationLevel() {

        return new Random().nextDouble() * 1.2;
    }

    public String getRadexRD1008UniqueKeyId() {
        return radexRD1008UniqueKeyId;
    }

    public void setRadexRD1008UniqueKeyId(String radexRD1008UniqueKeyId) {
        this.radexRD1008UniqueKeyId = radexRD1008UniqueKeyId;
    }

    public byte[] getRadexRD1008ControllerMatrice() {
        return radexRD1008ControllerMatrice;
    }

    public void setRadexRD1008ControllerMatrice(byte[] radexRD1008ControllerMatrice) {
        this.radexRD1008ControllerMatrice = radexRD1008ControllerMatrice;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
