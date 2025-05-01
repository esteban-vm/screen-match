package com.aluracursos.screenmatch.models;

import com.aluracursos.screenmatch.exceptions.DurationException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private int dateOfRelease;
    private int duration;
    private boolean includedInPlan;
    private int scoreCounter;
    private double totalScore;

    public Title(String title, int dateOfRelease) {
        this.title = title;
        this.dateOfRelease = dateOfRelease;
    }

    public Title(TitleOMDB titleOMDB) {
        this.title = titleOMDB.title();
        this.dateOfRelease = Integer.parseInt(titleOMDB.year());

        if (titleOMDB.runtime().contains("N/A")) {
            throw new DurationException("No se pudo convertir la duración porque contiene N/A");
        }

        this.duration = Integer.parseInt(titleOMDB.runtime().substring(0, 3).trim());
    }

    public void showDetails() {
        System.out.println("El nombre de la película es: " + title);
        System.out.println("Su fecha de lanzamiento es: " + dateOfRelease);
        System.out.println("Duración en minutos: " + getDurationInMinutes());
    }

    public void rate(double score) {
        totalScore += score;
        scoreCounter++;
    }

    public double calculateAverage() {
        return totalScore / scoreCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(int dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public int getDurationInMinutes() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public int getScoreCounter() {
        return scoreCounter;
    }

    @Override
    public int compareTo(Title title) {
        return this.getTitle().compareTo(title.getTitle());
    }

    @Override
    public String toString() {
        return "Título: " + title + ", Fecha de lanzamiento: " + dateOfRelease + ", Duración: " + duration + " minutos";
    }
}
