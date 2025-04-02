package com.example.demo.Controller;

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

    @GetMapping
    public List<History> getAllHistories() {
        return historyService.getAllHistories();
    }
    @PostMapping
    public History savehistory(@RequestBody History hs)
    {
        return historyService.savehistory(hs);
    }

    @GetMapping("/{id}")
    public Optional<History> getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    @GetMapping("/paged")
    public Page<History> getAllHistoriesPaged(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return historyService.getHistoriesPaged(pageable);
    }

   

    @PutMapping("/{id}")
    public History updateHistory(@PathVariable Long id, @RequestBody History historyDetails) {
        return historyService.updateHistory(id, historyDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable Long id) {
        boolean isDeleted = historyService.deleteHistory(id);
        return isDeleted ? "History record deleted successfully!" : "History record not found!";
    }
}
