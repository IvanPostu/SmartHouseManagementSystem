package com.ivan.app.iot;

import java.util.Random;

public class RadexF3 implements RadiationDosimiterComponent, Cloneable {

    private String radexF3UniqueIdentifier;
    private byte[] radexF3chipsetMatrice;

    public String getRadexF3UniqueIdentifier() {
        return radexF3UniqueIdentifier;
    }

    public void setRadexF3UniqueIdentifier(String radexF3UniqueIdentifier) {
        this.radexF3UniqueIdentifier = radexF3UniqueIdentifier;
    }

    public byte[] getRadexF3chipsetMatrice() {
        return radexF3chipsetMatrice;
    }

    public void setRadexF3chipsetMatrice(byte[] radexF3chipsetMatrice) {
        this.radexF3chipsetMatrice = radexF3chipsetMatrice;
    }

    @Override
    public double calculateCurrentRadiationLevel() {
        return new Random().nextDouble() * 1.33333;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
