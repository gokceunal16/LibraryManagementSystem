package com.example.library.api;

import com.example.library.entity.AudioBook;
import com.example.library.service.AudioBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AudioBookController {
    private final AudioBookService audio_bookService;

    public AudioBookController(AudioBookService audio_bookService) {
        this.audio_bookService = audio_bookService;
    }


    @PostMapping(value = "/audio_book")
    @ResponseBody
    public void createAudioBook(@RequestBody AudioBook audio_book){

        audio_bookService.createAudioBook(audio_book);
    }

    @GetMapping(value = "/audio_books")
    @ResponseBody
    public List<AudioBook> getAudioBooks(){

        return audio_bookService.getAudioBooks();
    }

    @GetMapping(value = "/audio_book/{id}")
    @ResponseBody
    public AudioBook findById(@PathVariable("id") int id){

        return audio_bookService.findById(id);
    }

    @PutMapping(value = "/audio_book/{id}")
    @ResponseBody
    public void updateAudioBook(@PathVariable("id") int id, @RequestBody AudioBook updatedAudioBook){

        audio_bookService.updateAudioBook(id, updatedAudioBook);
    }
}
