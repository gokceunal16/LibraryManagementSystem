package com.example.library.service;

import com.example.library.entity.PublicationAvailableNotificationRequest;
import com.example.library.repository.PublicationAvailableNotificationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationAvailableNotificationRequestService {
    private final PublicationAvailableNotificationRequestRepository publication_available_notification_requestRepository;

    @Autowired
    public PublicationAvailableNotificationRequestService(PublicationAvailableNotificationRequestRepository publication_available_notification_requestRepository) {
        this.publication_available_notification_requestRepository = publication_available_notification_requestRepository;
    }

    public void createPublicationAvailableNotificationRequest(PublicationAvailableNotificationRequest publication_available_notification_request) {
        publication_available_notification_requestRepository.createPublicationAvailableNotificationRequest(publication_available_notification_request);
    }

    public List<PublicationAvailableNotificationRequest> getPublicationAvailableNotificationRequests() {
        return publication_available_notification_requestRepository.getPublicationAvailableNotificationRequests();
    }

    public PublicationAvailableNotificationRequest find(int userId, int publicationId) {
        return publication_available_notification_requestRepository.find(userId, publicationId);
    }

    public void deletePublicationAvailableNotificationRequest(int user_id, int publication_id) {
        publication_available_notification_requestRepository.deletePublicationAvailableNotificationRequest(user_id, publication_id);
    }
}
