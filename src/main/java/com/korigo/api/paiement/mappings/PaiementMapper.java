package com.korigo.api.paiement.mappings;

        import com.korigo.api.paiement.dtos.PaiementRequest;
import com.korigo.api.paiement.entities.Paiement;
import com.korigo.api.paiement.resources.PaiementResource;

        public final class PaiementMapper {

            private PaiementMapper() {
            }

            public static Paiement toEntity(PaiementRequest request) {
                var entity = new Paiement();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Paiement entity, PaiementRequest request) {
                entity.setMode(request.mode());
        entity.setMontant(request.montant());
            }

            public static PaiementResource toResource(Paiement entity) {
                return new PaiementResource(
                    entity.getId(),
            entity.getMode(),
            entity.getMontant(),
            entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null,
            entity.getCourse() != null ? entity.getCourse().getId() : null,
            entity.getCommande() != null ? entity.getCommande().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
