import com.aluracursos.screenmatch.calculations.TimeCalculator;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setTitle("Encanto");
        movie1.setDateOfRelease(2021);
        movie1.setDuration(180);
        movie1.setIncludedInPlan(true);
        movie1.showDetails();
        movie1.rate(10);
        movie1.rate(10);
        System.out.println(movie1.calculateAverage());
        System.out.println(movie1.getScoreCounter());

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
        series.showDetails();
        System.out.println(series.getDurationInMinutes());

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(movie1);
        calculator.include(series);
        calculator.include(movie2);
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + calculator.getTotalTime() + "minutos");
    }
}
