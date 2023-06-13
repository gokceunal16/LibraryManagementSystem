package com.example.library.api;

import com.example.library.service.BookDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookDetailController {

    private final BookDetailService bookDetailService;

    public BookDetailController(BookDetailService bookDetailService) {
        this.bookDetailService = bookDetailService;
    }

    @GetMapping(value = "/book_details")
    @ResponseBody
    public List<Object> getReservations(){
        return bookDetailService.getBookDetails();
    }

    @GetMapping(value = "/book_detail/{publication_id}")
    @ResponseBody
    public List<Object> getReservationsByUserId(@PathVariable("publication_id") int publication_id){
        return bookDetailService.getBookDetails(publication_id);
    }


}
