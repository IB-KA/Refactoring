package programClasses;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        double total = 0;
        int frequentRenterPoints = 0;

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            total += calcPrice(each);
            result += entry(each);
            frequentRenterPoints += calcFrequentReterPoints(each);
        }
        //add footer lines

        result += "Amount owed is " + String.valueOf(total) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double calcPrice(Rental rental) {
        return rental.getMovie().calculateCharge(rental.getDaysRented());
    }

    private String entry(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getMovie().calculateCharge(rental.getDaysRented())) + "\n";
    }

    private int calcFrequentReterPoints(Rental rental) {
        return rental.calcPoints();
    }
}
    