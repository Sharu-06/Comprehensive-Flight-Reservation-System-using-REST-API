package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Flight;
import com.example.demo.Entity.History;
import com.example.demo.Repository.FlightRepository;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight flight) {
        if(flight.getHistories()!=null)
        {
            for(History hi:flight.getHistories())
            {
                hi.setFlight(flight);
            }
        }
        return flightRepository.save(flight);
    }

    public Optional<Flight> updateFlight(Long id, Flight flightDetails) {
        return flightRepository.findById(id).map(flight -> {
            flight.setFlightNumber(flightDetails.getFlightNumber());
            flight.setAirlineName(flightDetails.getAirlineName());
            flight.setDepartureLocation(flightDetails.getDepartureLocation());
            flight.setArrivalLocation(flightDetails.getArrivalLocation());
            flight.setDepartureTime(flightDetails.getDepartureTime());
            flight.setArrivalTime(flightDetails.getArrivalTime());
            flight.setTotalSeats(flightDetails.getTotalSeats());
            flight.setAvailableSeats(flightDetails.getAvailableSeats());
            flight.setTicketPrice(flightDetails.getTicketPrice());
            return flightRepository.save(flight);
        });
    }

    public boolean deleteFlight(Long id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
