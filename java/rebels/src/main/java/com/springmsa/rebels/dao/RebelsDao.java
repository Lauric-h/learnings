package com.springmsa.rebels.dao;

import com.springmsa.rebels.model.Rebels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RebelsDao extends JpaRepository<Rebels, Integer> {
    Rebels findById(int id);
}
