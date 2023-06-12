package com.example.library.service;

import com.example.library.entity.Reservation;
import com.example.library.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) {
        reservationRepository.createReservation(reservation);
    }

    public List<Object> getReservations() {
        return reservationRepository.getReservations();
    }

    public List<Object> getReservations(int user_id) {
        return reservationRepository.getReservations(user_id);
    }

    public Reservation findById(int id) {
        return reservationRepository.findById(id);
    }

    public void updateReservation(int id, Reservation reservation) {
        reservationRepository.updateReservation(id, reservation);
    }
}
