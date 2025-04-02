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

import com.example.demo.Entity.LoyaltyProgram;
import com.example.demo.Service.LoyaltyProgramService;

@RestController
@RequestMapping("/api/loyaltyprograms")
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    @PostMapping
    public LoyaltyProgram createLoyaltyProgram(@RequestBody LoyaltyProgram loyaltyProgram) {
        return loyaltyProgramService.saveLoyaltyProgram(loyaltyProgram);
    }

    @GetMapping
    public List<LoyaltyProgram> getAllLoyaltyPrograms() {
        return loyaltyProgramService.getAllLoyaltyPrograms();
    }

    @GetMapping("/{id}")
    public Optional<LoyaltyProgram> getLoyaltyProgramById(@PathVariable Long id) {
        return loyaltyProgramService.getLoyaltyProgramById(id);
    }

    @PutMapping("/{id}")
    public Optional<LoyaltyProgram> updateLoyaltyProgram(@PathVariable Long id, @RequestBody LoyaltyProgram loyaltyProgramDetails) {
        return loyaltyProgramService.updateLoyaltyProgram(id, loyaltyProgramDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteLoyaltyProgram(@PathVariable Long id) {
        boolean isDeleted = loyaltyProgramService.deleteLoyaltyProgram(id);
        return isDeleted ? "Loyalty Program record deleted successfully!" : "Loyalty Program record not found!";
    }
}
