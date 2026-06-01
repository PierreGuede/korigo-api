package com.korigo.api.vehicule.services;

        import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.vehicule.dtos.VehiculeRequest;
import com.korigo.api.vehicule.entities.Vehicule;
import com.korigo.api.vehicule.mappings.VehiculeMapper;
import com.korigo.api.vehicule.repositories.VehiculeRepository;
import com.korigo.api.vehicule.resources.VehiculeResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class VehiculeService extends AbstractCrudService<Vehicule, VehiculeRequest, VehiculeResource> {

            private final VehiculeRepository repository;
    private final ChauffeurRepository chauffeurRepository;

            public VehiculeService(VehiculeRepository repository, ChauffeurRepository chauffeurRepository) {
                super(repository, "Vehicule");
                this.repository = repository;
                this.chauffeurRepository = chauffeurRepository;
            }

            @Override
            protected Vehicule newEntity() {
                return new Vehicule();
            }

            @Override
            protected void mapForCreate(Vehicule entity, VehiculeRequest request) {
                VehiculeMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected void mapForUpdate(Vehicule entity, VehiculeRequest request) {
                VehiculeMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected VehiculeResource toResource(Vehicule entity) {
                return VehiculeMapper.toResource(entity);
            }
        }
