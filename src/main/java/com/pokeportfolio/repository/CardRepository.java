package com.pokeportfolio.repository;

import com.pokeportfolio.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}