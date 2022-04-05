package com.example.backend.repositories;

import com.example.backend.entity.PaoCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaoCardRepository extends JpaRepository<PaoCard, Long> {
}
