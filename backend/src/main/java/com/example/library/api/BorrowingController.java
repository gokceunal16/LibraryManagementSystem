package com.example.library.api;

import com.example.library.config.JwtService;
import com.example.library.entity.Borrowing;
import com.example.library.service.BorrowingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BorrowingController {
    private final BorrowingService borrowingService;
    private final JwtService jwtService;

    public BorrowingController(BorrowingService borrowingService, JwtService jwtService) {
        this.borrowingService = borrowingService;
        this.jwtService = jwtService;
    }


    @PostMapping(value = "/borrowing")
    @ResponseBody
    public void createBorrowing(@RequestBody Borrowing borrowing){

        borrowingService.createBorrowing(borrowing);
    }

    @GetMapping(value = "/borrowings")
    @ResponseBody
    public List<Borrowing> getBorrowings(){

        return borrowingService.getBorrowings();
    }

    @GetMapping(value = "user/borrowings")
    @ResponseBody
    public List<Borrowing> getBorrowingsByUserId(@RequestHeader("Authorization") String token){
        int user_id = jwtService.extractUserId(token.substring(7));
        return borrowingService.getBorrowings(user_id);
    }

    @GetMapping(value = "/borrowing/{id}")
    @ResponseBody
    public Borrowing findById(@PathVariable("id") int id){

        return borrowingService.findById(id);
    }

    @PutMapping(value = "/borrowing/{id}")
    @ResponseBody
    public void updateBorrowing(@PathVariable("id") int id, @RequestBody Borrowing updatedBorrowing){

        borrowingService.updateBorrowing(id, updatedBorrowing);
    }
}
