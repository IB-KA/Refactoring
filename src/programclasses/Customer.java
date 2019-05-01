package programclasses;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

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

        double total = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder();


        result.append("Rental Record for ").append(this.getName()).append("\n");
        result.append("\t").append("Title").append("\t").append("\t").append("Days").append("\t").append("Amount").append("\n");

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            total += calcPrice(each);
            result.append(entry(each));
            frequentRenterPoints += calcFrequentReterPoints(each);
        }

        result.append("Amount owed is ").append(String.valueOf(total)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
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
    