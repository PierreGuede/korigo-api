package com.korigo.api.retrait.services;

        import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.retrait.dtos.RetraitRequest;
import com.korigo.api.retrait.entities.Retrait;
import com.korigo.api.retrait.mappings.RetraitMapper;
import com.korigo.api.retrait.repositories.RetraitRepository;
import com.korigo.api.retrait.resources.RetraitResource;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class RetraitService extends AbstractCrudService<Retrait, RetraitRequest, RetraitResource> {

            private final RetraitRepository repository;
    private final ChauffeurRepository chauffeurRepository;

            public RetraitService(RetraitRepository repository, ChauffeurRepository chauffeurRepository) {
                super(repository, "Retrait");
                this.repository = repository;
                this.chauffeurRepository = chauffeurRepository;
            }

            @Override
            protected Retrait newEntity() {
                return new Retrait();
            }

            @Override
            protected void mapForCreate(Retrait entity, RetraitRequest request) {
                RetraitMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected void mapForUpdate(Retrait entity, RetraitRequest request) {
                RetraitMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected RetraitResource toResource(Retrait entity) {
                return RetraitMapper.toResource(entity);
            }
        }
