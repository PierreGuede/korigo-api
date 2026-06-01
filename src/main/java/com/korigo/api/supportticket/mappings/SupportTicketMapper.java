package com.korigo.api.supportticket.mappings;

        import com.korigo.api.supportticket.dtos.SupportTicketRequest;
import com.korigo.api.supportticket.entities.SupportTicket;
import com.korigo.api.supportticket.resources.SupportTicketResource;

        public final class SupportTicketMapper {

            private SupportTicketMapper() {
            }

            public static SupportTicket toEntity(SupportTicketRequest request) {
                var entity = new SupportTicket();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(SupportTicket entity, SupportTicketRequest request) {
                entity.setSujet(request.sujet());
        entity.setMessage(request.message());
        entity.setStatut(request.statut());
            }

            public static SupportTicketResource toResource(SupportTicket entity) {
                return new SupportTicketResource(
                    entity.getId(),
            entity.getSujet(),
            entity.getMessage(),
            entity.getStatut(),
            entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
