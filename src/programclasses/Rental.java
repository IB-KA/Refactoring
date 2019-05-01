package programclasses;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int calcPoints() {
        if ((this.movie instanceof NewMovie) && this.daysRented > 1)
            return 2;
        else return 1;
    }

}