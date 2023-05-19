package com.example.library.service;

import com.example.library.entity.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void createPublisher(Publisher publisher) {
        publisherRepository.createPublisher(publisher);
    }

    public List<Publisher> getPublishers() {
        return publisherRepository.getPublishers();
    }

    public Publisher findById(int id) {
        return publisherRepository.findById(id);
    }

    public void updatePublisher(int id, Publisher publisher) {
        publisherRepository.updatePublisher(id, publisher);
    }
}
