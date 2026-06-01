package com.korigo.api.paiement.repositories;

import com.korigo.api.paiement.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaiementRepository extends JpaRepository<Paiement, UUID> {
}
