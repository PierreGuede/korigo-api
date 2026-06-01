package com.korigo.api.chauffeur.mappings;

        import com.korigo.api.chauffeur.dtos.ChauffeurRequest;
import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.chauffeur.resources.ChauffeurResource;

        public final class ChauffeurMapper {

            private ChauffeurMapper() {
            }

            public static Chauffeur toEntity(ChauffeurRequest request) {
                var entity = new Chauffeur();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Chauffeur entity, ChauffeurRequest request) {
                entity.setActif(request.actif());
        entity.setStatut(request.statut());
        entity.setNote(request.note());
            }

            public static ChauffeurResource toResource(Chauffeur entity) {
                return new ChauffeurResource(
                    entity.getId(),
            entity.getActif(),
            entity.getStatut(),
            entity.getNote(),
            entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
