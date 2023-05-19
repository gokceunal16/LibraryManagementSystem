package com.example.library.api;

import com.example.library.entity.Genre;
import com.example.library.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }


    @PostMapping(value = "/genre")
    @ResponseBody
    public void createGenre(@RequestBody Genre genre){

        genreService.createGenre(genre);
    }

    @GetMapping(value = "/genres")
    @ResponseBody
    public List<Genre> getGenres(){

        return genreService.getGenres();
    }

    @GetMapping(value = "/genre/{id}")
    @ResponseBody
    public Genre findById(@PathVariable("id") int id){

        return genreService.findById(id);
    }

    @PutMapping(value = "/genre/{id}")
    @ResponseBody
    public void updateGenre(@PathVariable("id") int id, @RequestBody Genre updatedGenre){

        genreService.updateGenre(id, updatedGenre);
    }
}
