package com.example.demo.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAirlineName(String airlineName);

    List<Flight> findByDepartureLocation(String departureLocation);

    List<Flight> findByArrivalLocation(String arrivalLocation);

    @Query("SELECT f FROM Flight f WHERE f.departureLocation = :departure AND f.arrivalLocation = :arrival")
    List<Flight> findFlightsByRoute(@Param("departure") String departure, @Param("arrival") String arrival);

    @Query("SELECT f FROM Flight f WHERE f.availableSeats > 0")
    List<Flight> findAvailableFlights();

    @Query("SELECT f FROM Flight f WHERE f.ticketPrice < :maxPrice")
    List<Flight> findFlightsByMaxPrice(@Param("maxPrice") double maxPrice);

    
}

