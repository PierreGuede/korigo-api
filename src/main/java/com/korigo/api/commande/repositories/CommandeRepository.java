package com.korigo.api.commande.repositories;

import com.korigo.api.commande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommandeRepository extends JpaRepository<Commande, UUID> {
}
