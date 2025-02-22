package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Flight;
import com.example.demo.Service.FlightService;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // http://localhost:8080/api/flight
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    // http://localhost:8080/api/flight
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // http://localhost:8080/api/flight/2
    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    // http://localhost:8080/api/flight/2
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails).orElse(null);
    }

    // http://localhost:8080/api/flight/2
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        boolean isDeleted = flightService.deleteFlight(id);
        return isDeleted ? "Flight deleted successfully!" : "Flight not found!";
    }
}
/*{
    "flightNumber": "AI204",(this should unique when you add again)
    "airlineName": "Air India",
    "departureLocation": "New York",
    "arrivalLocation": "Los Angeles",
    "departureTime": "2025-02-20T10:00:00",
    "arrivalTime": "2025-02-20T14:00:00",
    "totalSeats": 180,
    "availableSeats": 50,
    "ticketPrice": 1000.0
}
 */
