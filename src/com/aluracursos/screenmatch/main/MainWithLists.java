package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.models.Title;

import java.util.ArrayList;

public class MainWithLists {
    public static void main(String[] args) {
        var movie1 = new Movie("Encanto", 2021);
        movie1.rate(9);
        var movie2 = new Movie("Matrix", 1998);
        movie2.rate(6);
        var movie3 = new Movie("El Señor de los Anillos", 2001);
        movie3.rate(10);
        var series = new Series("La casa del dragón", 2022);

        var list = new ArrayList<Title>();
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);
        list.add(series);

        for (Title title : list) {
            System.out.println(title.getTitle());

            if (title instanceof Movie movie && movie.getClassification() > 3) {
                System.out.println(movie.getClassification());
            }
        }
    }
}
