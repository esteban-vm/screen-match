package com.aluracursos.screenmatch.models;

import com.aluracursos.screenmatch.calculations.Classifiable;

public class Movie extends Title implements Classifiable {
    private String director;

    public Movie(String title, int dateOfRelease) {
        super(title, dateOfRelease);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) (calculateAverage() / 2);
    }

    @Override
    public String toString() {
        return String.format("Película: %s (%d)", this.getTitle(), this.getDateOfRelease());
    }
}
