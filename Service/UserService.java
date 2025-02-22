package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername() != null ? userDetails.getUsername() : user.getUsername());
            user.setEmail(userDetails.getEmail() != null ? userDetails.getEmail() : user.getEmail());
            user.setFirstName(userDetails.getFirstName() != null ? userDetails.getFirstName() : user.getFirstName());
            user.setLastName(userDetails.getLastName() != null ? userDetails.getLastName() : user.getLastName());
            user.setPhoneNumber(userDetails.getPhoneNumber() != null ? userDetails.getPhoneNumber() : user.getPhoneNumber());
            user.setAddress(userDetails.getAddress() != null ? userDetails.getAddress() : user.getAddress());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) { 
            userRepository.deleteById(id);
            return true; 
        }
        return false; 
}

    public Page<User> getUsersPaged(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
