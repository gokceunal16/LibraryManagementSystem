package com.example.library.api;

import com.example.library.entity.Reservation;
import com.example.library.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping(value = "/reservation")
    @ResponseBody
    public void createReservation(@RequestBody Reservation reservation){

        reservationService.createReservation(reservation);
    }

    @GetMapping(value = "/reservations")
    @ResponseBody
    public List<Reservation> getReservations(){

        return reservationService.getReservations();
    }

    @GetMapping(value = "/reservation/{id}")
    @ResponseBody
    public Reservation findById(@PathVariable("id") int id){

        return reservationService.findById(id);
    }

    @PutMapping(value = "/reservation/{id}")
    @ResponseBody
    public void updateReservation(@PathVariable("id") int id, @RequestBody Reservation updatedReservation){

        reservationService.updateReservation(id, updatedReservation);
    }
}
