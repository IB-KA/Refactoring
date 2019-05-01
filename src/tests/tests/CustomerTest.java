package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import programclasses.*;

class CustomerTest {

    private Customer customer;
    private String customerName;

    @BeforeEach
    void setUp() {
        customerName = "John";
        customer = new Customer(customerName);
    }

    @org.junit.jupiter.api.Test
    void addRental() {
        Rental rental = new Rental(new ChildrensMovie("Test movie"), 3);
        customer.addRental(rental);
        // Assertions.assertEquals(1,customer1.rentals.size());
        //Can't be tested before touching the code
    }

    @Test
    void getName() {
        Assertions.assertEquals("John", customer.getName());

    }

    @org.junit.jupiter.api.Test
    void statement() {
        customer.addRental(new Rental(new ChildrensMovie("children's"), 5));
        customer.addRental(new Rental(new RegularMovie("regular"), 3));
        customer.addRental(new Rental(new NewMovie("new release"), 10));
        Assertions.assertTrue(customer.statement().contains("for John"));
        Assertions.assertTrue(customer.statement().contains("children's" + "\t" + "\t" + 5 + "\t" + "4.5"));
        Assertions.assertTrue(customer.statement().contains("regular" + "\t" + "\t" + 3 + "\t" + "3.5"));
        Assertions.assertTrue(customer.statement().contains("new release" + "\t" + "\t" + 10 + "\t" + "30.0"));
        Assertions.assertTrue(customer.statement().contains("owed is 38.0"));
        Assertions.assertTrue(customer.statement().contains("earned 4 frequent"));

    }
}