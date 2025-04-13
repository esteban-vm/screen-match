import com.aluracursos.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Encanto");
        movie.setDateOfRelease(2021);
        movie.setDuration(180);
        movie.setIncludedInPlan(true);
        movie.showDetails();
        movie.rate(10);
        movie.rate(10);
        System.out.println(movie.calculateAverage());
        System.out.println(movie.getScoreCounter());

//        com.aluracursos.screenmatch.models.Movie movie1 = new com.aluracursos.screenmatch.models.Movie();
//        movie1.title = "Matrix";
//        movie1.dateOfRelease = 1998;
//        movie1.duration = 120;
//        movie1.showDetails();

    }
}
