package com.example.backend.repositories;

import com.example.backend.entity.Pao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaoRepository extends JpaRepository<Pao, Long> {
}
