package com.korigo.api.commission.repositories;

import com.korigo.api.commission.entities.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommissionRepository extends JpaRepository<Commission, UUID> {
}
