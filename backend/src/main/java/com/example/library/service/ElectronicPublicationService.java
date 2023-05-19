package com.example.library.service;

import com.example.library.entity.ElectronicPublication;
import com.example.library.repository.ElectronicPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicPublicationService {
    private final ElectronicPublicationRepository electronic_publicationRepository;

    @Autowired
    public ElectronicPublicationService(ElectronicPublicationRepository electronic_publicationRepository) {
        this.electronic_publicationRepository = electronic_publicationRepository;
    }

    public void createElectronicPublication(ElectronicPublication electronic_publication) {
        electronic_publicationRepository.createElectronicPublication(electronic_publication);
    }

    public List<ElectronicPublication> getElectronicPublications() {
        return electronic_publicationRepository.getElectronicPublications();
    }

    public ElectronicPublication findById(int id) {
        return electronic_publicationRepository.findById(id);
    }

    public void updateElectronicPublication(int id, ElectronicPublication electronic_publication) {
        electronic_publicationRepository.updateElectronicPublication(id, electronic_publication);
    }
}
