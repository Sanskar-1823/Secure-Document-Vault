package com.project.securedocumentvault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.securedocumentvault.entity.Document;

public interface DocumentRepository
        extends JpaRepository<Document, Long> {

}