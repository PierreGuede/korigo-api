package com.korigo.api.role.repositories;

import com.korigo.api.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByNomIgnoreCase(String nom);
}
