import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private String title;
    private int priceCode;
    Movie testmovie;

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