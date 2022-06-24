package pl.tomsza.moviesdirectory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(UUID id) {

        return movieRepository.findById(id)
                .orElseThrow();
    }

    public Movie createMovie(Movie movie) {
        movie.setId(UUID.randomUUID());
        movie = movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(UUID id, Movie movie) {
        Movie movieDB = movieRepository.findById(id)
                .orElseThrow();
        movieDB.setName(movie.getName());
        movieDB = movieRepository.save(movieDB);
        return movieDB;
    }

    public void deleteMovie(UUID id) {
        movieRepository.deleteById(id);
    }
}
