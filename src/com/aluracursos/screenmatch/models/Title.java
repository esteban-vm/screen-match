package com.aluracursos.screenmatch.models;

public class Title {
    private String title;
    private int dateOfRelease;
    private int duration;
    private boolean includedInPlan;
    private int scoreCounter;
    private double totalScore;

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
}
