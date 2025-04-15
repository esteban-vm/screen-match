package com.aluracursos.screenmatch.calculations;

import com.aluracursos.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void include(Title title) {
        this.totalTime += title.getDurationInMinutes();
    }
}
