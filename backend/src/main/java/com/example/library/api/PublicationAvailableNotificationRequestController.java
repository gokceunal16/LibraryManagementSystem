package com.example.library.api;

import com.example.library.entity.PublicationAvailableNotificationRequest;
import com.example.library.service.PublicationAvailableNotificationRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicationAvailableNotificationRequestController {
    private final PublicationAvailableNotificationRequestService publication_available_notification_requestService;

    public PublicationAvailableNotificationRequestController(PublicationAvailableNotificationRequestService publication_available_notification_requestService) {
        this.publication_available_notification_requestService = publication_available_notification_requestService;
    }


    @PostMapping(value = "/publication_available_notification_request")
    @ResponseBody
    public void createPublicationAvailableNotificationRequest(@RequestBody PublicationAvailableNotificationRequest publication_available_notification_request){

        publication_available_notification_requestService.createPublicationAvailableNotificationRequest(publication_available_notification_request);
    }

    @GetMapping(value = "/publication_available_notification_requests")
    @ResponseBody
    public List<PublicationAvailableNotificationRequest> getPublicationAvailableNotificationRequests(){

        return publication_available_notification_requestService.getPublicationAvailableNotificationRequests();
    }

    @GetMapping(value = "/publication_available_notification_request")
    @ResponseBody
    public PublicationAvailableNotificationRequest find(@RequestParam("user_id") int user_id, @RequestParam("publication_id") int publication_id){
        return publication_available_notification_requestService.find(user_id, publication_id);
    }


    @DeleteMapping(value = "/publication_available_notification_request")
    @ResponseBody
    public void deletePublicationAvailableNotificationRequest(@RequestParam("user_id") int user_id, @RequestParam("publication_id") int publication_id){

        publication_available_notification_requestService.deletePublicationAvailableNotificationRequest(user_id, publication_id);
    }
}
