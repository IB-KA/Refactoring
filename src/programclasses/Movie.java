package programclasses;

public abstract class Movie {

    private String title;

    public Movie(String newtitle) {
        title = newtitle;
    }

    public String getTitle (){
        return title;
    }

    public double calculateCharge(int daysRented) {
        return 0.0;
    }
}