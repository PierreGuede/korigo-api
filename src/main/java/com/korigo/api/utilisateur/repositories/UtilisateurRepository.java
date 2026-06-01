package com.korigo.api.utilisateur.repositories;

import com.korigo.api.utilisateur.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {
    Optional<Utilisateur> findByTelephone(String telephone);
    Optional<Utilisateur> findByEmailIgnoreCase(String email);
}
