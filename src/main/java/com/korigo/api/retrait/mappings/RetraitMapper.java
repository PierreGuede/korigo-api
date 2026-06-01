package com.korigo.api.retrait.mappings;

        import com.korigo.api.retrait.dtos.RetraitRequest;
import com.korigo.api.retrait.entities.Retrait;
import com.korigo.api.retrait.resources.RetraitResource;

        public final class RetraitMapper {

            private RetraitMapper() {
            }

            public static Retrait toEntity(RetraitRequest request) {
                var entity = new Retrait();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Retrait entity, RetraitRequest request) {
                entity.setMontant(request.montant());
        entity.setMethode(request.methode());
        entity.setStatut(request.statut());
            }

            public static RetraitResource toResource(Retrait entity) {
                return new RetraitResource(
                    entity.getId(),
            entity.getMontant(),
            entity.getMethode(),
            entity.getStatut(),
            entity.getChauffeur() != null ? entity.getChauffeur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
