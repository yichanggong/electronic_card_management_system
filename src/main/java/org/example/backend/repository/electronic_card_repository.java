package org.example.backend.repository;

import org.example.backend.entity.electronic_card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface electronic_card_repository extends JpaRepository<electronic_card,Integer> {}