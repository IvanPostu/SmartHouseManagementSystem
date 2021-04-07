package com.ivan.app.iot.builder;

import com.ivan.app.iot.RadiationDosimiterComponent;

public interface RadiationDosimiterBuilder<T extends RadiationDosimiterComponent> {

    public T getResult();

}
