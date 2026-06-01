package com.korigo.api.vehicule.controllers;

import com.korigo.api.vehicule.dtos.VehiculeRequest;
import com.korigo.api.vehicule.resources.VehiculeResource;
import com.korigo.api.vehicule.services.VehiculeService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController extends AbstractCrudController<VehiculeRequest, VehiculeResource> {

    public VehiculeController(VehiculeService service) {
        super(service);
    }
}
