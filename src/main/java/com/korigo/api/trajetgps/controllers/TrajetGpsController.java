package com.korigo.api.trajetgps.controllers;

import com.korigo.api.trajetgps.dtos.TrajetGpsRequest;
import com.korigo.api.trajetgps.resources.TrajetGpsResource;
import com.korigo.api.trajetgps.services.TrajetGpsService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trajets-gps")
public class TrajetGpsController extends AbstractCrudController<TrajetGpsRequest, TrajetGpsResource> {

    public TrajetGpsController(TrajetGpsService service) {
        super(service);
    }
}
