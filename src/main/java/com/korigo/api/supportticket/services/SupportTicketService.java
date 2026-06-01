package com.korigo.api.supportticket.services;

        import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.supportticket.dtos.SupportTicketRequest;
import com.korigo.api.supportticket.entities.SupportTicket;
import com.korigo.api.supportticket.mappings.SupportTicketMapper;
import com.korigo.api.supportticket.repositories.SupportTicketRepository;
import com.korigo.api.supportticket.resources.SupportTicketResource;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class SupportTicketService extends AbstractCrudService<SupportTicket, SupportTicketRequest, SupportTicketResource> {

            private final SupportTicketRepository repository;
    private final UtilisateurRepository utilisateurRepository;

            public SupportTicketService(SupportTicketRepository repository, UtilisateurRepository utilisateurRepository) {
                super(repository, "SupportTicket");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
            }

            @Override
            protected SupportTicket newEntity() {
                return new SupportTicket();
            }

            @Override
            protected void mapForCreate(SupportTicket entity, SupportTicketRequest request) {
                SupportTicketMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected void mapForUpdate(SupportTicket entity, SupportTicketRequest request) {
                SupportTicketMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected SupportTicketResource toResource(SupportTicket entity) {
                return SupportTicketMapper.toResource(entity);
            }
        }
