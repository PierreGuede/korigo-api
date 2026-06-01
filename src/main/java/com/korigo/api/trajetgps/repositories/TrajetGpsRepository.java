package com.korigo.api.trajetgps.repositories;

import com.korigo.api.trajetgps.entities.TrajetGps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrajetGpsRepository extends JpaRepository<TrajetGps, UUID> {
}
