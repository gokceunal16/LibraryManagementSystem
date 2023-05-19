package com.example.library.service;

import com.example.library.entity.AudioBook;
import com.example.library.repository.AudioBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioBookService {
    private final AudioBookRepository audio_bookRepository;

    @Autowired
    public AudioBookService(AudioBookRepository audio_bookRepository) {
        this.audio_bookRepository = audio_bookRepository;
    }

    public void createAudioBook(AudioBook audio_book) {
        audio_bookRepository.createAudioBook(audio_book);
    }

    public List<AudioBook> getAudioBooks() {
        return audio_bookRepository.getAudioBooks();
    }

    public AudioBook findById(int id) {
        return audio_bookRepository.findById(id);
    }

    public void updateAudioBook(int id, AudioBook audio_book) {
        audio_bookRepository.updateAudioBook(id, audio_book);
    }
}
