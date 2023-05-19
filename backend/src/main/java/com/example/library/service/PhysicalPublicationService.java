package com.example.library.service;

import com.example.library.entity.PhysicalPublication;
import com.example.library.repository.PhysicalPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalPublicationService {
    private final PhysicalPublicationRepository physical_publicationRepository;

    @Autowired
    public PhysicalPublicationService(PhysicalPublicationRepository physical_publicationRepository) {
        this.physical_publicationRepository = physical_publicationRepository;
    }

    public void createPhysicalPublication(PhysicalPublication physical_publication) {
        physical_publicationRepository.createPhysicalPublication(physical_publication);
    }

    public List<PhysicalPublication> getPhysicalPublications() {
        return physical_publicationRepository.getPhysicalPublications();
    }

    public PhysicalPublication findById(int id) {
        return physical_publicationRepository.findById(id);
    }

    public void updatePhysicalPublication(int id, PhysicalPublication physical_publication) {
        physical_publicationRepository.updatePhysicalPublication(id, physical_publication);
    }
}
