package com.example.demo.Controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.History;
import com.example.demo.Service.HistoryService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    // http://localhost:8080/api/history
    @PostMapping
    public History createHistory(@RequestBody History history) {
        if (history.getBookingDate() == null) {
            history.setBookingDate(LocalDate.now());
        }
        return historyService.saveHistory(history);
    }

    // http://localhost:8080/api/history
    @GetMapping
    public List<History> getAllHistories() {
        return historyService.getAllHistories();
    }

    // http://localhost:8080/api/history/3
    @GetMapping("/{id}")
    public Optional<History> getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }
    //http://localhost:8080/api/users/paged?page=0&size=5&sort=id,asc
    @GetMapping("/paged")
    public Page<History> getAllHistoriesPaged(
        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return HistoryService.getHistoriesPaged(pageable);
    }

    // http://localhost:8080/api/history/4
    @PutMapping("/{id}")
    public History updateHistory(@PathVariable Long id, @RequestBody History historyDetails) {
        return historyService.updateHistory(id, historyDetails).orElse(null);  // Handles update logic
    }

    // http://localhost:8080/api/history/6
    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable Long id) {
        boolean isDeleted = historyService.deleteHistory(id);
        return isDeleted ? "History deleted successfully!" : "History not found!";
    }
}
/*{
    "bookingDate": "2025-02-19",
  "status": "CONFIRMED",
  "amountPaid": "5000.0",
  "userId": "1",
  "flightId": "2636"
  
}*/