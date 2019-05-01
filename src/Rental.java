class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    double calculatePrice() {
        double price = 0;
        switch (this.movie.getPriceCode()) {
            case Movie.REGULAR:
                price += 2;
                if (this.daysRented > 2)
                    price += (this.daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                price += this.daysRented * 3;
                break;
            case Movie.CHILDRENS:
                price += 1.5;
                if (this.daysRented > 3)
                    price += (this.daysRented - 3) * 1.5;
                break;
        }
        return price;
    }

    int calcPoints() {
        if ((this.movie.getPriceCode() == Movie.NEW_RELEASE) && this.daysRented > 1)
            return 2;
        else return 1;
    }

}