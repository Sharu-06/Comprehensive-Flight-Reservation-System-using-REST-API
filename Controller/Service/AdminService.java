package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Admin;
import com.example.demo.Repository.AdminRepository;

@Service
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        if (admin.getTimestamp() == null) {
            admin.setTimestamp(LocalDateTime.now());  
        }
        return adminRepository.save(admin);
    }

    public Optional<Admin> updateAdmin(Long id, Admin adminDetails) {
        return adminRepository.findById(id).map(admin -> {
            admin.setUpdateType(adminDetails.getUpdateType());
            admin.setTimestamp(adminDetails.getTimestamp());
            admin.setDetails(adminDetails.getDetails());
            return adminRepository.save(admin);
        });
    }

    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
