package com.example.library.api;

import com.example.library.config.JwtService;
import com.example.library.entity.Reservation;
import com.example.library.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {
    private final ReservationService reservationService;
    private final JwtService jwtService;

    public ReservationController(ReservationService reservationService, JwtService jwtService) {
        this.reservationService = reservationService;
        this.jwtService = jwtService;
    }


    @PostMapping(value = "/reservation")
    @ResponseBody
    public void createReservation(@RequestBody Reservation reservation, @RequestHeader("Authorization") String token){

        if (reservation.getUser_id() == 0) {
            int user_id = jwtService.extractUserId(token.substring(7));
            reservation.setUser_id(user_id);
        }
        reservationService.createReservation(reservation);
    }

    @GetMapping(value = "reservations")
    @ResponseBody
    public List<Reservation> getReservations(){

        return reservationService.getReservations();
    }

    @GetMapping(value = "user/reservations")
    @ResponseBody
    public List<Reservation> getReservationsByUserId(@RequestHeader("Authorization") String token){
        int user_id = jwtService.extractUserId(token.substring(7));
        return reservationService.getReservations(user_id);
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
