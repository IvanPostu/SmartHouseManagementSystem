package com.ivan.app.iot;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class RadiationDosimiterNetwork implements RadiationDosimiterComponent {

    private List<RadiationDosimiterComponent> radiationDosimeters;

    public RadiationDosimiterNetwork() {
        this.radiationDosimeters = new ArrayList<>();
    }

    public void add(RadiationDosimiterComponent radiationDosimiterComponent) {
        this.radiationDosimeters.add(radiationDosimiterComponent);
    }

    public void remove(RadiationDosimiterComponent radiationDosimiterComponent) {
        this.radiationDosimeters.remove(radiationDosimiterComponent);
    }

    public List<RadiationDosimiterComponent> getRadiationDosimeters() {
        return this.radiationDosimeters;
    }

    @Override
    public double calculateCurrentRadiationLevel() {

        DoubleSummaryStatistics doubleSummaryStatistics = this.radiationDosimeters.stream()
                .mapToDouble((a) -> a.calculateCurrentRadiationLevel()).summaryStatistics();

        return doubleSummaryStatistics.getAverage();
    }

}
