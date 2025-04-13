public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.title = "Matrix";
        movie1.dateOfRelease = 1998;
        movie1.duration = 120;
        movie1.showDetails();

        Movie movie2 = new Movie();
        movie2.title = "Encanto";
        movie2.dateOfRelease = 2021;
        movie2.duration = 180;
        movie2.showDetails();
        movie2.rate(10);
        movie2.rate(10);
        System.out.println(movie2.totalScore);
        System.out.println(movie2.calculateAverage());
    }
}
