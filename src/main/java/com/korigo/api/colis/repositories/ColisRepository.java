package com.korigo.api.colis.repositories;

import com.korigo.api.colis.entities.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColisRepository extends JpaRepository<Colis, UUID> {
}
