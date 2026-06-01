package com.korigo.api.role.controllers;

import com.korigo.api.role.dtos.RoleRequest;
import com.korigo.api.role.resources.RoleResource;
import com.korigo.api.role.services.RoleService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends AbstractCrudController<RoleRequest, RoleResource> {

    public RoleController(RoleService service) {
        super(service);
    }
}
