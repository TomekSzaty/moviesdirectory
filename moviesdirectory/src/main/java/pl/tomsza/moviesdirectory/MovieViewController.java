package pl.tomsza.moviesdirectory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieViewController {

    private final MovieService movieService;

    @GetMapping
    String indexView(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return "index";
    }
}

