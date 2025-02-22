package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.History;
import com.example.demo.Repository.HistoryRepository;

@Service
@Transactional
public class HistoryService {

    private static HistoryRepository historyRepository;
    
        public static HistoryRepository getHistoryRepository() {
            return historyRepository;
        }
                
                   
        @Autowired
        public HistoryService(HistoryRepository historyRepository) {
            HistoryService.historyRepository = historyRepository;
        }
        
            
            public List<History> getAllHistories() {
                return historyRepository.findAll();
            }
        
            
            public Optional<History> getHistoryById(Long id) {
                return historyRepository.findById(id);
            }
        
            
            public History saveHistory(History history) {
                if (history.getBookingDate() == null) {
                    history.setBookingDate(LocalDate.now());  
                }
                return historyRepository.save(history);
            }
        
            
            public Optional<History> updateHistory(Long id, History historyDetails) {
                return historyRepository.findById(id).map(history -> {
                    history.setUserId(historyDetails.getUserId());
                    history.setFlightId(historyDetails.getFlightId());
                    history.setBookingDate(historyDetails.getBookingDate());
                    history.setStatus(historyDetails.getStatus());
                    return historyRepository.save(history);
                });
            }
        
            
            public boolean deleteHistory(Long id) {
                if (historyRepository.existsById(id)) {
                    historyRepository.deleteById(id);
                    return true; 
                }
                return false;
            }
        
            
            public static Page<History> getHistoriesPaged(Pageable pageable) {
                return historyRepository.findAll(pageable); 
    }
}

