package pl.tomsza.moviesdirectory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movies")
public class MovieApiController {


    private final MovieService movieService;

    @GetMapping
    Iterable<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    Movie getMovie(@PathVariable UUID id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("{id}")
    Movie updateMovie(@PathVariable UUID id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }

}
