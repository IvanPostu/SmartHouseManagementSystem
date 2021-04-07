package com.ivan.app.iot.builder;

import java.util.UUID;

public class RadiationDosimeterDirector {
    private RadiationDosimiterBuilder<?> builder;

    public RadiationDosimeterDirector(RadiationDosimiterBuilder<?> builder) {
        this.builder = builder;
    }

    public void changeBuilder(RadiationDosimiterBuilder<?> builder) {
        this.builder = builder;
    }

    public void make() {
        if (this.builder instanceof RadexF3Builder) {
            RadexF3Builder b = (RadexF3Builder) this.builder;
            b.setRadexF3UniqueIdentifier(UUID.randomUUID().toString());
            b.setRadexF3chipsetMatrice(new byte[] { 1, 2, 3 });
        }

        if (this.builder instanceof RadexRD1008Builder) {
            RadexRD1008Builder b = (RadexRD1008Builder) this.builder;
            b.setRadexRD1008UniqueKeyId(UUID.randomUUID().toString());
            b.setRadexRD1008ControllerMatrice(new byte[] { 1, 2, 3 });
        }
    }
}
