package com.korigo.api.supportticket.controllers;

import com.korigo.api.supportticket.dtos.SupportTicketRequest;
import com.korigo.api.supportticket.resources.SupportTicketResource;
import com.korigo.api.supportticket.services.SupportTicketService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController extends AbstractCrudController<SupportTicketRequest, SupportTicketResource> {

    public SupportTicketController(SupportTicketService service) {
        super(service);
    }
}
