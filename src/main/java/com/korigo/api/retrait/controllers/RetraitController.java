package com.korigo.api.retrait.controllers;

import com.korigo.api.retrait.dtos.RetraitRequest;
import com.korigo.api.retrait.resources.RetraitResource;
import com.korigo.api.retrait.services.RetraitService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retraits")
public class RetraitController extends AbstractCrudController<RetraitRequest, RetraitResource> {

    public RetraitController(RetraitService service) {
        super(service);
    }
}
