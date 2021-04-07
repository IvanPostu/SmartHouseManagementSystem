package com.ivan.app.iot.builder;

import com.ivan.app.iot.RadexRD1008;

public class RadexRD1008Builder implements RadiationDosimiterBuilder<RadexRD1008> {

    private RadexRD1008 result;

    public RadexRD1008Builder() {
        this.result = new RadexRD1008();
    }

    @Override
    public RadexRD1008 getResult() {
        try {
            return (RadexRD1008) result.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public RadexRD1008Builder setRadexRD1008UniqueKeyId(String radexRD1008UniqueKeyId) {
        this.result.setRadexRD1008UniqueKeyId(radexRD1008UniqueKeyId);
        return this;
    }

    public RadexRD1008Builder setRadexRD1008ControllerMatrice(byte[] radexRD1008ControllerMatrice) {
        this.result.setRadexRD1008ControllerMatrice(radexRD1008ControllerMatrice);
        return this;
    }

}
