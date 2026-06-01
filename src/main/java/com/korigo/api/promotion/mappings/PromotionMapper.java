package com.korigo.api.promotion.mappings;

        import com.korigo.api.promotion.dtos.PromotionRequest;
import com.korigo.api.promotion.entities.Promotion;
import com.korigo.api.promotion.resources.PromotionResource;

        public final class PromotionMapper {

            private PromotionMapper() {
            }

            public static Promotion toEntity(PromotionRequest request) {
                var entity = new Promotion();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Promotion entity, PromotionRequest request) {
                entity.setCode(request.code());
        entity.setReduction(request.reduction());
        entity.setDateDebut(request.dateDebut());
        entity.setDateFin(request.dateFin());
            }

            public static PromotionResource toResource(Promotion entity) {
                return new PromotionResource(
                    entity.getId(),
            entity.getCode(),
            entity.getReduction(),
            entity.getDateDebut(),
            entity.getDateFin(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
