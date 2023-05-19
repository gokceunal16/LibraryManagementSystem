package com.example.library.api;

import com.example.library.entity.EBook;
import com.example.library.service.EBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EBookController {
    private final EBookService e_bookService;

    public EBookController(EBookService e_bookService) {
        this.e_bookService = e_bookService;
    }


    @PostMapping(value = "/e_book")
    @ResponseBody
    public void createEBook(@RequestBody EBook e_book){

        e_bookService.createEBook(e_book);
    }

    @GetMapping(value = "/e_books")
    @ResponseBody
    public List<EBook> getEBooks(){

        return e_bookService.getEBooks();
    }

    @GetMapping(value = "/e_book/{id}")
    @ResponseBody
    public EBook findById(@PathVariable("id") int id){

        return e_bookService.findById(id);
    }

    @PutMapping(value = "/e_book/{id}")
    @ResponseBody
    public void updateEBook(@PathVariable("id") int id, @RequestBody EBook updatedEBook){

        e_bookService.updateEBook(id, updatedEBook);
    }
}
