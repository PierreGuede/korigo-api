package com.korigo.api.commande.mappings;

        import com.korigo.api.commande.dtos.CommandeRequest;
import com.korigo.api.commande.entities.Commande;
import com.korigo.api.commande.resources.CommandeResource;

        public final class CommandeMapper {

            private CommandeMapper() {
            }

            public static Commande toEntity(CommandeRequest request) {
                var entity = new Commande();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Commande entity, CommandeRequest request) {
                entity.setMontant(request.montant());
        entity.setStatut(request.statut());
            }

            public static CommandeResource toResource(Commande entity) {
                return new CommandeResource(
                    entity.getId(),
            entity.getMontant(),
            entity.getStatut(),
            entity.getClient() != null ? entity.getClient().getId() : null,
            entity.getRestaurant() != null ? entity.getRestaurant().getId() : null,
            entity.getChauffeur() != null ? entity.getChauffeur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
