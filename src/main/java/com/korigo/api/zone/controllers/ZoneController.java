package com.korigo.api.zone.controllers;

import com.korigo.api.zone.dtos.ZoneRequest;
import com.korigo.api.zone.resources.ZoneResource;
import com.korigo.api.zone.services.ZoneService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zones")
public class ZoneController extends AbstractCrudController<ZoneRequest, ZoneResource> {

    public ZoneController(ZoneService service) {
        super(service);
    }
}
