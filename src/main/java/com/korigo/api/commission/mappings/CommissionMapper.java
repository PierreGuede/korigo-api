package com.korigo.api.commission.mappings;

        import com.korigo.api.commission.dtos.CommissionRequest;
import com.korigo.api.commission.entities.Commission;
import com.korigo.api.commission.resources.CommissionResource;

        public final class CommissionMapper {

            private CommissionMapper() {
            }

            public static Commission toEntity(CommissionRequest request) {
                var entity = new Commission();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Commission entity, CommissionRequest request) {
                entity.setMontant(request.montant());
        entity.setPourcentage(request.pourcentage());
            }

            public static CommissionResource toResource(Commission entity) {
                return new CommissionResource(
                    entity.getId(),
            entity.getMontant(),
            entity.getPourcentage(),
            entity.getCourse() != null ? entity.getCourse().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
