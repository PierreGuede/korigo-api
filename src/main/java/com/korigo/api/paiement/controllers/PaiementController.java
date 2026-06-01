package com.korigo.api.paiement.controllers;

import com.korigo.api.paiement.dtos.PaiementRequest;
import com.korigo.api.paiement.resources.PaiementResource;
import com.korigo.api.paiement.services.PaiementService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController extends AbstractCrudController<PaiementRequest, PaiementResource> {

    public PaiementController(PaiementService service) {
        super(service);
    }
}
