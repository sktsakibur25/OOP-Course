package Day_5.Practice_8;

import java.util.ArrayList;
import java.util.List;

public class MoviePlatform {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, Genre.SCIENCE_FICTION);
        Movie movie2 = new Movie("The Godfather", "Francis Ford Coppola", 1972, Genre.DRAMA);
        Movie movie3 = new Movie("Toy Story", "John Lasseter", 1995, Genre.ANIMATION);
        Movie movie4 = new Movie("The Dark Knight", "Christopher Nolan", 2008, Genre.ACTION);
        Movie movie5 = new Movie("Parasite", "Bong Joon-ho", 2019, Genre.DRAMA);
        Movie movie6 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, Genre.DRAMA);
        Movie movie7 = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, Genre.THRILLER);
        Movie movie8 = new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, Genre.SCIENCE_FICTION);
        Movie movie9 = new Movie("Forrest Gump", "Robert Zemeckis", 1994, Genre.DRAMA);
        Movie movie10 = new Movie("The Lion King", "Roger Allers, Rob Minkoff", 1994, Genre.ANIMATION);

        List<Movie> movies = List.of(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10);

        User user1 = new User("Alice","alice@gmail.com");
        User user2 = new User("Bob","bob@gmail.com");

        try {
            user1.addToWatchList(movie1);

            user1.addToWatchList(movie2);
            user1.addToWatchList(movie3);
            user1.addToWatchList(movie8);
            

            user2.addToWatchList(movie1);
            user2.addToWatchList(movie2);
            user2.addToWatchList(movie9);

            // User 1 watches and rates movies
            user1.watch(movie1);
            user1.rateMovie(movie1, 9.0);

            user1.watch(movie2);
            user1.rateMovie(movie2, 8.5);

            // User 2 watches and rates movies
            user2.watch(movie1);
            user2.rateMovie(movie1, 8.0);

            suggestMovies(user1, movies);
            suggestMovies(user2, movies);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void suggestMovies(User user, List<Movie> movies) {
        System.out.println("Suggested Movies for " + user.getName() + ":");
        List<Genre> preferredGenres = user.getPreferredGenres();
        List<Movie> suggestedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (preferredGenres.contains(movie.getGenre())) {
                suggestedMovies.add(movie);
            }
        }
        if (suggestedMovies.isEmpty()) {
            System.out.println("No movies found in preferred genres.");
        } else {
            for (Movie movie : suggestedMovies) {
                movie.printDetails();
            }
        }
    }

}
