package com.hexletlection.introapp.dao;

import com.hexletlection.introapp.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
}
