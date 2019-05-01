package programclasses;

public class RegularMovie extends Movie {

    public RegularMovie(String newtitle) {
        super(newtitle);
    }

    public double calculateCharge(int daysRented) {
        if (daysRented > 2) {
            return ((daysRented - 2) * 1.5 + 2);
        } else {
            return 2;
        }
    }
}
