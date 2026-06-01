package com.korigo.api.kycdocument.mappings;

        import com.korigo.api.kycdocument.dtos.KycDocumentRequest;
import com.korigo.api.kycdocument.entities.KycDocument;
import com.korigo.api.kycdocument.resources.KycDocumentResource;

        public final class KycDocumentMapper {

            private KycDocumentMapper() {
            }

            public static KycDocument toEntity(KycDocumentRequest request) {
                var entity = new KycDocument();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(KycDocument entity, KycDocumentRequest request) {
                entity.setTypeDocument(request.typeDocument());
        entity.setStatut(request.statut());
            }

            public static KycDocumentResource toResource(KycDocument entity) {
                return new KycDocumentResource(
                    entity.getId(),
            entity.getTypeDocument(),
            entity.getStatut(),
            entity.getChauffeur() != null ? entity.getChauffeur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
