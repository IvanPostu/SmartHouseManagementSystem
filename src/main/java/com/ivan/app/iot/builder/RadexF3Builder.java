package com.ivan.app.iot.builder;

import com.ivan.app.iot.RadexF3;

public class RadexF3Builder implements RadiationDosimiterBuilder<RadexF3> {

    private RadexF3 result;

    public RadexF3Builder() {
        this.result = new RadexF3();
    }

    public RadexF3Builder setRadexF3UniqueIdentifier(String uId) {
        this.result.setRadexF3UniqueIdentifier(uId);
        return this;
    }

    public RadexF3Builder setRadexF3chipsetMatrice(byte[] chipsetMatrice) {
        this.result.setRadexF3chipsetMatrice(chipsetMatrice);
        return this;
    }

    @Override
    public RadexF3 getResult() {
        try {
            return (RadexF3) result.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
