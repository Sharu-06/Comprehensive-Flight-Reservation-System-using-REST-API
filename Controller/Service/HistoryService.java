package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.History;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.HistoryRepository;
import com.example.demo.Repository.UserRepository;



@Service
@Transactional
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    public History savehistory(@RequestBody History hi) {
        return historyRepository.save(hi);
    }

    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }

    public Optional<History> getHistoryById(Long id) {
        return historyRepository.findById(id);
    }

    public History updateHistory(Long id, History historyDetails) {
        Optional<History> existingHistoryOpt = historyRepository.findById(id);

        if (existingHistoryOpt.isPresent()) {
            History existingHistory = existingHistoryOpt.get();
                existingHistory.setBookingDate(historyDetails.getBookingDate());

                existingHistory.setStatus(historyDetails.getStatus());
                existingHistory.setAmountPaid(historyDetails.getAmountPaid());

            return historyRepository.save(existingHistory);
        }

        return null; 
    }

    public boolean deleteHistory(Long id) {
        if (historyRepository.existsById(id)) {
            historyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<History> getHistoriesPaged(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }
}
