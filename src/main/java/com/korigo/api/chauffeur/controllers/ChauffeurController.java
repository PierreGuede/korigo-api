package com.korigo.api.chauffeur.controllers;

import com.korigo.api.chauffeur.dtos.ChauffeurRequest;
import com.korigo.api.chauffeur.resources.ChauffeurResource;
import com.korigo.api.chauffeur.services.ChauffeurService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chauffeurs")
public class ChauffeurController extends AbstractCrudController<ChauffeurRequest, ChauffeurResource> {

    public ChauffeurController(ChauffeurService service) {
        super(service);
    }
}
