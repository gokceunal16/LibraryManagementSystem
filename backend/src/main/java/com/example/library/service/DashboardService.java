package com.example.library.service;

import com.example.library.repository.DashboardRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public HashMap<String, Integer> getCounts() {
        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("audio_books", dashboardRepository.getAudioBookCount());
        counts.put("e_books", dashboardRepository.getEBookCount());
        counts.put("physical_books", dashboardRepository.getPhysicalBookCount());
        counts.put("newspapers", dashboardRepository.getNewspaperCount());
        counts.put("materials", dashboardRepository.getMaterialCount());
        counts.put("rooms", dashboardRepository.getRoomCount());
        counts.put("publications", dashboardRepository.getPublicationCount());
        counts.put("borrowed_publications", dashboardRepository.getBorrowedPublicationCount());

        return counts;
    }

    public HashMap<String, Integer> getAvailableCounts() {
        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("publications", dashboardRepository.getAvailablePublicationCount());
        counts.put("newspapers", dashboardRepository.getAvailableNewspaperCount());
        counts.put("physical_books", dashboardRepository.getAvailablePhysicalBookCount());
        counts.put("materials", dashboardRepository.getAvailableMaterialCount());

        return counts;
    }

    public List<DashboardRepository.PublicationScore> getHighestRatedPublications() {
        return dashboardRepository.getHighestRatedPublications();
    }

    public  List<DashboardRepository.PublicationScore> getHighestRatedPublicationsInLastThreeMonths() {
        return dashboardRepository.getHighestRatedPublicationsInLastThreeMonths();
    }
}
