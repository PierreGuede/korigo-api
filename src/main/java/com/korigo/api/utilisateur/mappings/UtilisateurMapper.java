package com.korigo.api.utilisateur.mappings;

import com.korigo.api.auth.resources.AuthSessionResource;
import com.korigo.api.utilisateur.dtos.UtilisateurRequest;
import com.korigo.api.utilisateur.entities.Utilisateur;
import com.korigo.api.utilisateur.resources.UtilisateurResource;
import java.util.Locale;

public final class UtilisateurMapper {

    private UtilisateurMapper() {
    }

    public static Utilisateur toEntity(UtilisateurRequest request) {
        var entity = new Utilisateur();
        updateEntity(entity, request);
        return entity;
    }

    public static void updateEntity(Utilisateur entity, UtilisateurRequest request) {
        entity.setNom(request.nom().trim());
        entity.setTelephone(request.telephone().trim());
        entity.setEmail(request.email().trim().toLowerCase(Locale.ROOT));
    }

    public static UtilisateurResource toResource(Utilisateur entity) {
        return new UtilisateurResource(
            entity.getId(),
            entity.getNom(),
            entity.getTelephone(),
            entity.getEmail(),
            entity.getRole() != null ? entity.getRole().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    public static AuthSessionResource toAuthSessionResource(Utilisateur entity) {
        return new AuthSessionResource(
            entity.getId(),
            entity.getNom(),
            entity.getTelephone(),
            entity.getEmail(),
            entity.getRole() != null ? entity.getRole().getId() : null
        );
    }
}
