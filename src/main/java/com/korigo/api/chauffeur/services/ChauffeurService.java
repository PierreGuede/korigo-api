package com.korigo.api.chauffeur.services;

        import com.korigo.api.chauffeur.dtos.ChauffeurRequest;
import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.chauffeur.mappings.ChauffeurMapper;
import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.chauffeur.resources.ChauffeurResource;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class ChauffeurService extends AbstractCrudService<Chauffeur, ChauffeurRequest, ChauffeurResource> {

            private final ChauffeurRepository repository;
    private final UtilisateurRepository utilisateurRepository;

            public ChauffeurService(ChauffeurRepository repository, UtilisateurRepository utilisateurRepository) {
                super(repository, "Chauffeur");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
            }

            @Override
            protected Chauffeur newEntity() {
                return new Chauffeur();
            }

            @Override
            protected void mapForCreate(Chauffeur entity, ChauffeurRequest request) {
                ChauffeurMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected void mapForUpdate(Chauffeur entity, ChauffeurRequest request) {
                ChauffeurMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected ChauffeurResource toResource(Chauffeur entity) {
                return ChauffeurMapper.toResource(entity);
            }
        }
