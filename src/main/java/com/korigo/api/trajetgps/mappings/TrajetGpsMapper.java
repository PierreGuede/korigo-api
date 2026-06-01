package com.korigo.api.trajetgps.mappings;

        import com.korigo.api.trajetgps.dtos.TrajetGpsRequest;
import com.korigo.api.trajetgps.entities.TrajetGps;
import com.korigo.api.trajetgps.resources.TrajetGpsResource;

        public final class TrajetGpsMapper {

            private TrajetGpsMapper() {
            }

            public static TrajetGps toEntity(TrajetGpsRequest request) {
                var entity = new TrajetGps();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(TrajetGps entity, TrajetGpsRequest request) {
                entity.setLatitude(request.latitude());
        entity.setLongitude(request.longitude());
        entity.setTimestamp(request.timestamp());
            }

            public static TrajetGpsResource toResource(TrajetGps entity) {
                return new TrajetGpsResource(
                    entity.getId(),
            entity.getLatitude(),
            entity.getLongitude(),
            entity.getTimestamp(),
            entity.getCourse() != null ? entity.getCourse().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
