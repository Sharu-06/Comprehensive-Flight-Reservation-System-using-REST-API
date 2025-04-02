package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Reservation;
import com.example.demo.Repository.ReservationRepository;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    

    
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setReservationDate(reservationDetails.getReservationDate());
            reservation.setStatus(reservationDetails.getStatus());
            reservation.setPaymentStatus(reservationDetails.getPaymentStatus());
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Reservation not found with ID: " + id);
        }
    }

    
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false; 
    }
}

