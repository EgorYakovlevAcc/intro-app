package com.hexletlection.introapp.dao;

import com.hexletlection.introapp.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
