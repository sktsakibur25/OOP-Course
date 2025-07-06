package Day_5.Practice_8;

import java.util.ArrayList;
import java.util.List;

import Day_5.Practice_8.Exception.DuplicateEntryException;
import Day_5.Practice_8.Exception.InvalidRateValueException;

public class Movie {
    private String title;
    private String director;
    private int year;
    private Genre genre;
    private Double rating;
    private Double max_rating = 10.0;
    private List<User> usersRated;
    private int ratingCount = 0;
    private Double totalRating = 0.0;


    public Movie(String title, String director, int year, Genre genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = 0.0;
        this.usersRated = new ArrayList<>();
    }

    public void rate( User user, double rating) throws InvalidRateValueException, DuplicateEntryException {
        if (rating >= 0 && rating <= max_rating) {
            this.ratingCount++;
            this.totalRating += rating;
            // Calculate the new average rating
            this.rating = this.totalRating / (this.ratingCount * 1.0);
            // Add the user to the list of users who rated this movie
            if (!usersRated.contains(user)) {
                usersRated.add(user);
            }else {
                throw new DuplicateEntryException("User " + user.getName() + " has already rated this movie.");
            }
        } else {
            throw new InvalidRateValueException("Rating must be between 0 and " + max_rating);
        }
    }

    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
    }
    
    public String getTitle() {
        return title;
    }
    
    public Genre getGenre() {
        return genre;
    }


}
