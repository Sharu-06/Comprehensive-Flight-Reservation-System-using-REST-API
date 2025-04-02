package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reservation;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
