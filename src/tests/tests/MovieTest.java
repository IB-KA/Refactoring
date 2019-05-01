package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programClasses.Movie;
import programClasses.NewMovie;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private String title;
    private int priceCode;
    private Movie testmovie;

    @BeforeEach
    void setUp() {
        title = "Testmovie";
        testmovie = new NewMovie(title);
    }

    @Test
    void getTitle() {
        assertEquals("Testmovie", testmovie.getTitle());
    }
}