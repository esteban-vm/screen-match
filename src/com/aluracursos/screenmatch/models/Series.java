package com.aluracursos.screenmatch.models;

public class Series extends Title {
    private int seasons;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public Series(String title, int dateOfRelease) {
        super(title, dateOfRelease);
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return String.format("Serie: %s (%d)", this.getTitle(), this.getDateOfRelease());
    }
}
