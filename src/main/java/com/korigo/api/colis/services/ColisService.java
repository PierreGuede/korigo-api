package com.korigo.api.colis.services;

        import com.korigo.api.colis.dtos.ColisRequest;
import com.korigo.api.colis.entities.Colis;
import com.korigo.api.colis.mappings.ColisMapper;
import com.korigo.api.colis.repositories.ColisRepository;
import com.korigo.api.colis.resources.ColisResource;
import com.korigo.api.commande.repositories.CommandeRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class ColisService extends AbstractCrudService<Colis, ColisRequest, ColisResource> {

            private final ColisRepository repository;
    private final CommandeRepository commandeRepository;

            public ColisService(ColisRepository repository, CommandeRepository commandeRepository) {
                super(repository, "Colis");
                this.repository = repository;
                this.commandeRepository = commandeRepository;
            }

            @Override
            protected Colis newEntity() {
                return new Colis();
            }

            @Override
            protected void mapForCreate(Colis entity, ColisRequest request) {
                ColisMapper.updateEntity(entity, request);
        entity.setCommande(findRequired(commandeRepository, request.commandeId(), "Commande"));
            }

            @Override
            protected void mapForUpdate(Colis entity, ColisRequest request) {
                ColisMapper.updateEntity(entity, request);
        entity.setCommande(findRequired(commandeRepository, request.commandeId(), "Commande"));
            }

            @Override
            protected ColisResource toResource(Colis entity) {
                return ColisMapper.toResource(entity);
            }
        }
