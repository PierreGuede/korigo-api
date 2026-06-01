package com.korigo.api.colis.mappings;

        import com.korigo.api.colis.dtos.ColisRequest;
import com.korigo.api.colis.entities.Colis;
import com.korigo.api.colis.resources.ColisResource;

        public final class ColisMapper {

            private ColisMapper() {
            }

            public static Colis toEntity(ColisRequest request) {
                var entity = new Colis();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Colis entity, ColisRequest request) {
                entity.setDescription(request.description());
        entity.setPoids(request.poids());
            }

            public static ColisResource toResource(Colis entity) {
                return new ColisResource(
                    entity.getId(),
            entity.getDescription(),
            entity.getPoids(),
            entity.getCommande() != null ? entity.getCommande().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
