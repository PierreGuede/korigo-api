package com.korigo.api.promotion.controllers;

import com.korigo.api.promotion.dtos.PromotionRequest;
import com.korigo.api.promotion.resources.PromotionResource;
import com.korigo.api.promotion.services.PromotionService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController extends AbstractCrudController<PromotionRequest, PromotionResource> {

    public PromotionController(PromotionService service) {
        super(service);
    }
}
