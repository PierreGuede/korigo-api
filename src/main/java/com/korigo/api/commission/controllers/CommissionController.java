package com.korigo.api.commission.controllers;

import com.korigo.api.commission.dtos.CommissionRequest;
import com.korigo.api.commission.resources.CommissionResource;
import com.korigo.api.commission.services.CommissionService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commissions")
public class CommissionController extends AbstractCrudController<CommissionRequest, CommissionResource> {

    public CommissionController(CommissionService service) {
        super(service);
    }
}
