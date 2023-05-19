package com.example.library.service;

import com.example.library.entity.TimeSlot;
import com.example.library.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService {
    private final TimeSlotRepository time_slotRepository;

    @Autowired
    public TimeSlotService(TimeSlotRepository time_slotRepository) {
        this.time_slotRepository = time_slotRepository;
    }

    public void createTimeSlot(TimeSlot time_slot) {
        time_slotRepository.createTimeSlot(time_slot);
    }

    public List<TimeSlot> getTimeSlots() {
        return time_slotRepository.getTimeSlots();
    }

    public TimeSlot findById(int id) {
        return time_slotRepository.findById(id);
    }

    public void updateTimeSlot(int id, TimeSlot time_slot) {
        time_slotRepository.updateTimeSlot(id, time_slot);
    }
}
