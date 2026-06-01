package com.korigo.api.zone.mappings;

        import com.korigo.api.zone.dtos.ZoneRequest;
import com.korigo.api.zone.entities.Zone;
import com.korigo.api.zone.resources.ZoneResource;

        public final class ZoneMapper {

            private ZoneMapper() {
            }

            public static Zone toEntity(ZoneRequest request) {
                var entity = new Zone();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Zone entity, ZoneRequest request) {
                entity.setNom(request.nom());
        entity.setType(request.type());
            }

            public static ZoneResource toResource(Zone entity) {
                return new ZoneResource(
                    entity.getId(),
            entity.getNom(),
            entity.getType(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
