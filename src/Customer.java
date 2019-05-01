import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    ;
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };

    public String statement() {


        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.calculatePrice()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(calcTotal()) + "\n";
        result += "You earned " + String.valueOf(calcFrequentReterPoints()) + " frequent renter points";
        return result;
    }

    double calcTotal() {
        double totalAmount = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            totalAmount += each.calculatePrice();
        }
        return totalAmount;
    }

    int calcFrequentReterPoints() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += each.calcPoints();
        }
        return frequentRenterPoints;
    }
}
    