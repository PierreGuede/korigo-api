package com.korigo.api.zone.repositories;

import com.korigo.api.zone.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ZoneRepository extends JpaRepository<Zone, UUID> {
}
