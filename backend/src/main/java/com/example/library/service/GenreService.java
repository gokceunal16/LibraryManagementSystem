package com.example.library.service;

import com.example.library.entity.Genre;
import com.example.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void createGenre(Genre genre) {
        genreRepository.createGenre(genre);
    }

    public List<Genre> getGenres() {
        return genreRepository.getGenres();
    }

    public Genre findById(int id) {
        return genreRepository.findById(id);
    }

    public void updateGenre(int id, Genre genre) {
        genreRepository.updateGenre(id, genre);
    }
}
