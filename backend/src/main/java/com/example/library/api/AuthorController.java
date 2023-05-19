package com.example.library.api;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/author")
    @ResponseBody
    public void createAuthor(@RequestBody Author author){

        authorService.createAuthor(author);
    }

    @GetMapping(value = "/authors")
    @ResponseBody
    public List<Author> getAuthors(){

        return authorService.getAuthors();
    }

    @GetMapping(value = "/author/{id}")
    @ResponseBody
    public Author findById(@PathVariable("id") int id){

        return authorService.findById(id);
    }

    @PutMapping(value = "/author/{id}")
    @ResponseBody
    public void updateAuthor(@PathVariable("id") int id, @RequestBody Author updatedAuthor){

        authorService.updateAuthor(id, updatedAuthor);
    }
}
