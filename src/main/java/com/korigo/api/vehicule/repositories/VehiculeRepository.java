package com.korigo.api.vehicule.repositories;

import com.korigo.api.vehicule.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehiculeRepository extends JpaRepository<Vehicule, UUID> {
}
