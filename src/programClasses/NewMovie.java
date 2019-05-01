package programClasses;

public class NewMovie extends Movie {


    public NewMovie(String newtitle) {
        super(newtitle);
    }

    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }
}
