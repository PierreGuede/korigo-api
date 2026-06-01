package com.korigo.api.restaurant.controllers;

import com.korigo.api.restaurant.dtos.RestaurantRequest;
import com.korigo.api.restaurant.resources.RestaurantResource;
import com.korigo.api.restaurant.services.RestaurantService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController extends AbstractCrudController<RestaurantRequest, RestaurantResource> {

    public RestaurantController(RestaurantService service) {
        super(service);
    }
}
