package com.korigo.api.chauffeur.repositories;

import com.korigo.api.chauffeur.entities.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, UUID> {
}
