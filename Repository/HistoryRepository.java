package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    
}
