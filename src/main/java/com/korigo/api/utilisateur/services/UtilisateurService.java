package com.korigo.api.utilisateur.services;

import com.korigo.api.role.repositories.RoleRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.dtos.UtilisateurRequest;
import com.korigo.api.utilisateur.entities.Utilisateur;
import com.korigo.api.utilisateur.mappings.UtilisateurMapper;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import com.korigo.api.utilisateur.resources.UtilisateurResource;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurService extends AbstractCrudService<Utilisateur, UtilisateurRequest, UtilisateurResource> {

    private final UtilisateurRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(
        UtilisateurRepository repository,
        RoleRepository roleRepository,
        PasswordEncoder passwordEncoder
    ) {
        super(repository, "Utilisateur");
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected Utilisateur newEntity() {
        return new Utilisateur();
    }

    @Override
    protected void mapForCreate(Utilisateur entity, UtilisateurRequest request) {
        UtilisateurMapper.updateEntity(entity, request);
        entity.setRole(findRequired(roleRepository, request.roleId(), "Role"));
        validateEmailAvailability(request.email(), null);
        applyPassword(entity, request.password(), true);
    }

    @Override
    protected void mapForUpdate(Utilisateur entity, UtilisateurRequest request) {
        UtilisateurMapper.updateEntity(entity, request);
        entity.setRole(findRequired(roleRepository, request.roleId(), "Role"));
        validateEmailAvailability(request.email(), entity.getId());
        applyPassword(entity, request.password(), false);
    }

    @Override
    protected UtilisateurResource toResource(Utilisateur entity) {
        return UtilisateurMapper.toResource(entity);
    }

    @Transactional(readOnly = true)
    public Optional<UtilisateurResource> findByTelephone(String telephone) {
        return repository.findByTelephone(telephone.trim()).map(UtilisateurMapper::toResource);
    }

    @Transactional(readOnly = true)
    public Optional<Utilisateur> findEntityByEmail(String email) {
        return repository.findByEmailIgnoreCase(email.trim());
    }

    private void validateEmailAvailability(String email, UUID currentUserId) {
        repository.findByEmailIgnoreCase(email.trim())
            .filter(existingUser -> currentUserId == null || !existingUser.getId().equals(currentUserId))
            .ifPresent(existingUser -> {
                throw new IllegalArgumentException("Cet email est deja utilise.");
            });
    }

    private void applyPassword(Utilisateur entity, String rawPassword, boolean required) {
        final String normalizedPassword = rawPassword == null ? "" : rawPassword.trim();
        if (normalizedPassword.isEmpty()) {
            if (required && (entity.getPasswordHash() == null || entity.getPasswordHash().isBlank())) {
                throw new IllegalArgumentException("Le mot de passe est obligatoire pour creer un utilisateur.");
            }
            return;
        }

        if (normalizedPassword.length() < 6) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 6 caracteres.");
        }

        entity.setPasswordHash(passwordEncoder.encode(normalizedPassword));
    }
}
