package katas.exercises;

import katas.exercises.movieRental.Movie;
import katas.exercises.movieRental.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * The refactored MovieRentalCustomer class with statement and HTML statement generation.
 */
public class MovieRentalCustomer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public MovieRentalCustomer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    /**
     * Generates the rental statement in plain text format.
     *
     * @return the rental statement in plain text
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : _rentals) {
            // Calculate rental amount and frequent renter points
            double thisAmount = calculateAmount(each);
            frequentRenterPoints += calculateFrequentRenterPoints(each);

            // Append the rental info to the result
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");

            totalAmount += thisAmount;
        }

        // Append the footer
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }

    /**
     * Generates the rental statement in HTML format.
     *
     * @return the rental statement in HTML format
     */
    public String htmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1>");
        result.append("<table>");

        for (Rental each : _rentals) {
            // Calculate rental amount and frequent renter points
            double thisAmount = calculateAmount(each);
            frequentRenterPoints += calculateFrequentRenterPoints(each);

            // Append the rental info in HTML format
            result.append("<tr><td>")
                    .append(each.getMovie().getTitle())
                    .append("</td><td>")
                    .append(thisAmount)
                    .append("</td></tr>");

            totalAmount += thisAmount;
        }

        // Append the footer
        result.append("</table>");
        result.append("<p>Amount owed is <em>").append(totalAmount).append("</em></p>");
        result.append("<p>You earned <em>").append(frequentRenterPoints).append("</em> frequent renter points</p>");

        return result.toString();
    }

    /**
     * Calculates the rental amount for a given rental.
     *
     * @param rental the rental
     * @return the rental amount
     */
    private double calculateAmount(Rental rental) {
        double thisAmount = 0;

        // Determine the amount for this rental based on movie price code and days rented
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    /**
     * Calculates the frequent renter points for a given rental.
     *
     * @param rental the rental
     * @return the frequent renter points
     */
    private int calculateFrequentRenterPoints(Rental rental) {
        int points = 1;

        // Add bonus for a two-day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            points++;

        return points;
    }
}
