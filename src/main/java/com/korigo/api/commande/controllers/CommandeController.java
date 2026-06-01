package com.korigo.api.commande.controllers;

import com.korigo.api.commande.dtos.CommandeRequest;
import com.korigo.api.commande.resources.CommandeResource;
import com.korigo.api.commande.services.CommandeService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController extends AbstractCrudController<CommandeRequest, CommandeResource> {

    public CommandeController(CommandeService service) {
        super(service);
    }
}
