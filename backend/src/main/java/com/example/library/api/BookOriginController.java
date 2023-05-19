package com.example.library.api;

import com.example.library.entity.BookOrigin;
import com.example.library.service.BookOriginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookOriginController {
    private final BookOriginService book_originService;

    public BookOriginController(BookOriginService book_originService) {
        this.book_originService = book_originService;
    }


    @PostMapping(value = "/book_origin")
    @ResponseBody
    public void createBookOrigin(@RequestBody BookOrigin book_origin){

        book_originService.createBookOrigin(book_origin);
    }

    @GetMapping(value = "/book_origins")
    @ResponseBody
    public List<BookOrigin> getBookOrigins(){

        return book_originService.getBookOrigins();
    }

    @GetMapping(value = "/book_origin/{id}")
    @ResponseBody
    public BookOrigin findById(@PathVariable("id") int id){

        return book_originService.findById(id);
    }

    @PutMapping(value = "/book_origin/{id}")
    @ResponseBody
    public void updateBookOrigin(@PathVariable("id") int id, @RequestBody BookOrigin updatedBookOrigin){

        book_originService.updateBookOrigin(id, updatedBookOrigin);
    }
}
