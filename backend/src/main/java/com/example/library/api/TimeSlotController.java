package com.example.library.api;

import com.example.library.entity.TimeSlot;
import com.example.library.service.TimeSlotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TimeSlotController {
    private final TimeSlotService time_slotService;

    public TimeSlotController(TimeSlotService time_slotService) {
        this.time_slotService = time_slotService;
    }


    @PostMapping(value = "/time_slot")
    @ResponseBody
    public void createTimeSlot(@RequestBody TimeSlot time_slot){

        time_slotService.createTimeSlot(time_slot);
    }

    @GetMapping(value = "/time_slots")
    @ResponseBody
    public List<TimeSlot> getTimeSlots(){

        return time_slotService.getTimeSlots();
    }

    @GetMapping(value = "/time_slot/{id}")
    @ResponseBody
    public TimeSlot findById(@PathVariable("id") int id){

        return time_slotService.findById(id);
    }

    @PutMapping(value = "/time_slot/{id}")
    @ResponseBody
    public void updateTimeSlot(@PathVariable("id") int id, @RequestBody TimeSlot updatedTimeSlot){

        time_slotService.updateTimeSlot(id, updatedTimeSlot);
    }
}
