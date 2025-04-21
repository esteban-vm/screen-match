import com.aluracursos.screenmatch.calculations.RecommendationFilter;
import com.aluracursos.screenmatch.calculations.TimeCalculator;
import com.aluracursos.screenmatch.models.Episode;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setTitle("Encanto");
        movie1.setDateOfRelease(2021);
        movie1.setDuration(180);
        movie1.setIncludedInPlan(true);
        // movie1.showDetails();
        movie1.rate(10);
        movie1.rate(10);
        // System.out.println(movie1.calculateAverage());
        // System.out.println(movie1.getScoreCounter());

        Movie movie2 = new Movie();
        movie2.setTitle("Matrix");
        movie2.setDateOfRelease(1998);
        movie2.setDuration(180);

        Series series = new Series();
        series.setTitle("La casa del dragón");
        series.setDateOfRelease(2022);
        series.setSeasons(1);
        series.setMinutesPerEpisode(50);
        series.setEpisodesPerSeason(10);
        // series.showDetails();
        // System.out.println(series.getDurationInMinutes());

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(movie1);
        calculator.include(series);
        calculator.include(movie2);
        // System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + calculator.getTotalTime() + "minutos");

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setName("La casa Targaryen");
        episode.setSeries(series);
        episode.setTotalViews(50);

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        recommendationFilter.filter(movie1);
        recommendationFilter.filter(episode);

        var movie3 = new Movie();
        movie3.setTitle("El Señor de los Anillos");
        movie3.setDuration(180);
        movie3.setDateOfRelease(2001);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

        System.out.println("Cantidad de películas: " + movieList.size());
        System.out.println("La primera película es: " + movieList.getFirst().getTitle());
        System.out.println(movieList);
    }
}
