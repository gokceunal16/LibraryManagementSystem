package com.example.library.api;

import com.example.library.repository.DashboardRepository;
import com.example.library.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping(value = "/counts")
    @ResponseBody
    public HashMap<String, Integer> getCounts(){
        return dashboardService.getCounts();
    }

    @GetMapping(value = "/availabilities")
    @ResponseBody
    public HashMap<String, Integer> getAvailableCounts(){
        return dashboardService.getAvailableCounts();
    }

    @GetMapping(value = "/highest-rated-publications")
    @ResponseBody
    public List<DashboardRepository.PublicationScore> getHighestRatedPublications(){
        return dashboardService.getHighestRatedPublications();
    }

    @GetMapping(value = "/highest-rated-publications-last-three-months")
    @ResponseBody
    public List<DashboardRepository.PublicationScore> getHighestRatedPublicationsInLastThreeMonths(){
        return dashboardService.getHighestRatedPublicationsInLastThreeMonths();
    }
}
