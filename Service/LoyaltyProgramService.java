package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.LoyaltyProgram;
import com.example.demo.Repository.LoyaltyProgramRepository;

@Service
@Transactional
public class LoyaltyProgramService {

    private final LoyaltyProgramRepository loyaltyProgramRepository;

    @Autowired
    public LoyaltyProgramService(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }

    public List<LoyaltyProgram> getAllLoyaltyPrograms() {
        return loyaltyProgramRepository.findAll();
    }

    public Optional<LoyaltyProgram> getLoyaltyProgramById(Long id) {
        return loyaltyProgramRepository.findById(id);
    }

    public LoyaltyProgram saveLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        return loyaltyProgramRepository.save(loyaltyProgram);
    }

    public Optional<LoyaltyProgram> updateLoyaltyProgram(Long id, LoyaltyProgram loyaltyProgramDetails) {
        return loyaltyProgramRepository.findById(id).map(loyaltyProgram -> {
            loyaltyProgram.setPointsEarned(loyaltyProgramDetails.getPointsEarned());
            loyaltyProgram.setPointsRedeemed(loyaltyProgramDetails.getPointsRedeemed());
            loyaltyProgram.setTier(loyaltyProgramDetails.getTier());
            return loyaltyProgramRepository.save(loyaltyProgram);
        });
    }

    public boolean deleteLoyaltyProgram(Long id) {
        if (loyaltyProgramRepository.existsById(id)) {
            loyaltyProgramRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
