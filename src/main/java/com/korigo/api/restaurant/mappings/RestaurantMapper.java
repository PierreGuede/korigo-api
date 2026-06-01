package com.korigo.api.restaurant.mappings;

        import com.korigo.api.restaurant.dtos.RestaurantRequest;
import com.korigo.api.restaurant.entities.Restaurant;
import com.korigo.api.restaurant.resources.RestaurantResource;

        public final class RestaurantMapper {

            private RestaurantMapper() {
            }

            public static Restaurant toEntity(RestaurantRequest request) {
                var entity = new Restaurant();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Restaurant entity, RestaurantRequest request) {
                entity.setNom(request.nom());
        entity.setAdresse(request.adresse());
        entity.setTelephone(request.telephone());
            }

            public static RestaurantResource toResource(Restaurant entity) {
                return new RestaurantResource(
                    entity.getId(),
            entity.getNom(),
            entity.getAdresse(),
            entity.getTelephone(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
