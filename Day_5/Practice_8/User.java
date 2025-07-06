package Day_5.Practice_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Day_5.Practice_8.Exception.DuplicateEntryException;
import Day_5.Practice_8.Exception.InvalidRateValueException;
import Day_5.Practice_8.Exception.UnseenMovieException;

public class User {
    
    private String name;
    @SuppressWarnings("unused")
    private String email;

    List<Movie> watchList;
    List<Movie> watchedMovies;
    Set<Genre> preferredGenres;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.watchList = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.preferredGenres = new HashSet<>();
    }

    public void addToWatchList(Movie movie) throws DuplicateEntryException {
        if (!watchList.contains(movie)) {
            watchList.add(movie);
        }else {
            throw new DuplicateEntryException(name + " already has " + movie.getTitle() + " in their watchlist.");
        }
    }

    public void watch(Movie movie){
        if (!watchedMovies.contains(movie)) {
            this.watchedMovies.add(movie);
            this.preferredGenres.add(movie.getGenre());
        }
    }

    public void rateMovie(Movie movie, double rating) throws UnseenMovieException, InvalidRateValueException, DuplicateEntryException {
        if (this.watchedMovies.contains(movie)) {
            movie.rate(this, rating);
        } else {
            throw new UnseenMovieException("You must watch the movie before rating it.");
        }
    }

    public String getName() {
        return name;
    }

    public List<Genre> getPreferredGenres() {
        return this.preferredGenres.stream().toList();
    }

    public void printWatchList() {
        if (watchList.isEmpty()) {
            System.out.println("Watch list is empty.");
        } else {
            for (Movie movie : watchList) {
                movie.printDetails();
            }
        }   
    }

}
