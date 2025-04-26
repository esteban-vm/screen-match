package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainWithLists {
    public static void main(String[] args) {
        var movie1 = new Movie("Encanto", 2021);
        movie1.rate(9);
        var movie2 = new Movie("Matrix", 1998);
        movie2.rate(6);
        var movie3 = new Movie("El Señor de los Anillos", 2001);
        movie3.rate(10);
        var series = new Series("La casa del dragón", 2022);

        var titles = new ArrayList<Title>();
        titles.add(movie1);
        titles.add(movie2);
        titles.add(movie3);
        titles.add(series);

        for (Title title : titles) {
            System.out.println(title.getTitle());

            if (title instanceof Movie movie && movie.getClassification() > 3) {
                System.out.println(movie.getClassification());
            }
        }

        var artists = new ArrayList<String>();
        artists.add("Penélope Cruz");
        artists.add("Antonio Banderas");
        artists.add("Ricardo Darín");

        System.out.println("Lista de artistas no ordenada: " + artists);
        Collections.sort(artists);
        System.out.println("Lista de artistas ordenada: " + artists);

        System.out.println("Lista de títulos no ordenada: " + titles);
        Collections.sort(titles);
        System.out.println("Lista de títulos ordenada: " + titles);

        titles.sort(Comparator.comparing(Title::getDateOfRelease));
        System.out.println("Lista de títulos ordenada por fecha de lanzamiento: " + titles);
    }
}
