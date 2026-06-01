package com.korigo.api.retrait.repositories;

import com.korigo.api.retrait.entities.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RetraitRepository extends JpaRepository<Retrait, UUID> {
}
