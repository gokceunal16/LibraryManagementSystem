package com.example.library.api;

import com.example.library.entity.PhysicalBook;
import com.example.library.service.PhysicalBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhysicalBookController {
    private final PhysicalBookService physical_bookService;

    public PhysicalBookController(PhysicalBookService physical_bookService) {
        this.physical_bookService = physical_bookService;
    }


    @PostMapping(value = "/physical_book")
    @ResponseBody
    public void createPhysicalBook(@RequestBody PhysicalBook physical_book){

        physical_bookService.createPhysicalBook(physical_book);
    }

    @GetMapping(value = "/physical_books")
    @ResponseBody
    public List<PhysicalBook> getPhysicalBooks(){

        return physical_bookService.getPhysicalBooks();
    }

    @GetMapping(value = "/physical_book/{id}")
    @ResponseBody
    public PhysicalBook findById(@PathVariable("id") int id){

        return physical_bookService.findById(id);
    }

    @PutMapping(value = "/physical_book/{id}")
    @ResponseBody
    public void updatePhysicalBook(@PathVariable("id") int id, @RequestBody PhysicalBook updatedPhysicalBook){

        physical_bookService.updatePhysicalBook(id, updatedPhysicalBook);
    }
}
