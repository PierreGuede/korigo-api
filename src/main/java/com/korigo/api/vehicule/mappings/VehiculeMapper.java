package com.korigo.api.vehicule.mappings;

        import com.korigo.api.vehicule.dtos.VehiculeRequest;
import com.korigo.api.vehicule.entities.Vehicule;
import com.korigo.api.vehicule.resources.VehiculeResource;

        public final class VehiculeMapper {

            private VehiculeMapper() {
            }

            public static Vehicule toEntity(VehiculeRequest request) {
                var entity = new Vehicule();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Vehicule entity, VehiculeRequest request) {
                entity.setType(request.type());
        entity.setMarque(request.marque());
        entity.setModele(request.modele());
        entity.setImmatriculation(request.immatriculation());
        entity.setCouleur(request.couleur());
            }

            public static VehiculeResource toResource(Vehicule entity) {
                return new VehiculeResource(
                    entity.getId(),
            entity.getType(),
            entity.getMarque(),
            entity.getModele(),
            entity.getImmatriculation(),
            entity.getCouleur(),
            entity.getChauffeur() != null ? entity.getChauffeur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
