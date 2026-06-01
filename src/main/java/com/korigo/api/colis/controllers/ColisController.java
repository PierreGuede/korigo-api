package com.korigo.api.colis.controllers;

import com.korigo.api.colis.dtos.ColisRequest;
import com.korigo.api.colis.resources.ColisResource;
import com.korigo.api.colis.services.ColisService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colis")
public class ColisController extends AbstractCrudController<ColisRequest, ColisResource> {

    public ColisController(ColisService service) {
        super(service);
    }
}
