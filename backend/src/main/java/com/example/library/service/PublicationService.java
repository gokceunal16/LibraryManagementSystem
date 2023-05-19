package com.example.library.service;

import com.example.library.entity.Publication;
import com.example.library.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public void createPublication(Publication publication) {
        publicationRepository.createPublication(publication);
    }

    public List<Publication> getPublications() {
        return publicationRepository.getPublications();
    }

    public Publication findById(int id) {
        return publicationRepository.findById(id);
    }

    public void updatePublication(int id, Publication publication) {
        publicationRepository.updatePublication(id, publication);
    }
}
