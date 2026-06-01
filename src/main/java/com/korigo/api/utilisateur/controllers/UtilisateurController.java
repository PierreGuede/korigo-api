package com.korigo.api.utilisateur.controllers;

import com.korigo.api.utilisateur.dtos.UtilisateurRequest;
import com.korigo.api.utilisateur.resources.UtilisateurResource;
import com.korigo.api.utilisateur.services.UtilisateurService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController extends AbstractCrudController<UtilisateurRequest, UtilisateurResource> {

    public UtilisateurController(UtilisateurService service) {
        super(service);
        this.service = service;
    }

    private final UtilisateurService service;

    @GetMapping("/by-telephone")
    public ResponseEntity<UtilisateurResource> findByTelephone(@RequestParam String telephone) {
        Optional<UtilisateurResource> utilisateur = service.findByTelephone(telephone);
        return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
