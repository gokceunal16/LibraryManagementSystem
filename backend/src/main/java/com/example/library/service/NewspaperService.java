package com.example.library.service;

import com.example.library.entity.Newspaper;
import com.example.library.repository.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperService {
    private final NewspaperRepository newspaperRepository;

    @Autowired
    public NewspaperService(NewspaperRepository newspaperRepository) {
        this.newspaperRepository = newspaperRepository;
    }

    public void createNewspaper(Newspaper newspaper) {
        newspaperRepository.createNewspaper(newspaper);
    }

    public List<Newspaper> getNewspapers() {
        return newspaperRepository.getNewspapers();
    }

    public Newspaper findById(int id) {
        return newspaperRepository.findById(id);
    }

    public void updateNewspaper(int id, Newspaper newspaper) {
        newspaperRepository.updateNewspaper(id, newspaper);
    }
}
