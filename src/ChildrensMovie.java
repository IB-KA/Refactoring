public class ChildrensMovie extends Movie {

    public ChildrensMovie(String newtitle) {
        super(newtitle);
    }

    public double calculateCharge(int daysRented) {
        if (daysRented > 3) {
            return (((daysRented - 3) * 1.5) + 1.5);
        } else {
            return 1.5;
        }
    }
}

