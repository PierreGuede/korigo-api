package com.korigo.api.restaurant.services;

        import com.korigo.api.restaurant.dtos.RestaurantRequest;
import com.korigo.api.restaurant.entities.Restaurant;
import com.korigo.api.restaurant.mappings.RestaurantMapper;
import com.korigo.api.restaurant.repositories.RestaurantRepository;
import com.korigo.api.restaurant.resources.RestaurantResource;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class RestaurantService extends AbstractCrudService<Restaurant, RestaurantRequest, RestaurantResource> {

            private final RestaurantRepository repository;

            public RestaurantService(RestaurantRepository repository) {
                super(repository, "Restaurant");
                this.repository = repository;

            }

            @Override
            protected Restaurant newEntity() {
                return new Restaurant();
            }

            @Override
            protected void mapForCreate(Restaurant entity, RestaurantRequest request) {
                RestaurantMapper.updateEntity(entity, request);
            }

            @Override
            protected void mapForUpdate(Restaurant entity, RestaurantRequest request) {
                RestaurantMapper.updateEntity(entity, request);
            }

            @Override
            protected RestaurantResource toResource(Restaurant entity) {
                return RestaurantMapper.toResource(entity);
            }
        }
