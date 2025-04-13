public class Movie {
    String title;
    int dateOfRelease;
    int duration;
    boolean includedInPlan;
    double totalScore;
    int scoreCounter;

    public void showDetails() {
        System.out.println("El nombre de la película es: " + this.title);
        System.out.println("Su fecha de lanzamiento es: " + this.dateOfRelease);
        System.out.println("Duración en minutos: " + this.duration);
    }

    public void rate(double score) {
        this.totalScore += score;
        this.scoreCounter++;
    }

    public double calculateAverage() {
        return totalScore / scoreCounter;
    }
}
