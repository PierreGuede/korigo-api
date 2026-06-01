package com.korigo.api.paiement.services;

        import com.korigo.api.commande.repositories.CommandeRepository;
import com.korigo.api.course.repositories.CourseRepository;
import com.korigo.api.paiement.dtos.PaiementRequest;
import com.korigo.api.paiement.entities.Paiement;
import com.korigo.api.paiement.mappings.PaiementMapper;
import com.korigo.api.paiement.repositories.PaiementRepository;
import com.korigo.api.paiement.resources.PaiementResource;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class PaiementService extends AbstractCrudService<Paiement, PaiementRequest, PaiementResource> {

            private final PaiementRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final CourseRepository courseRepository;
    private final CommandeRepository commandeRepository;

            public PaiementService(PaiementRepository repository, UtilisateurRepository utilisateurRepository, CourseRepository courseRepository, CommandeRepository commandeRepository) {
                super(repository, "Paiement");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
        this.courseRepository = courseRepository;
        this.commandeRepository = commandeRepository;
            }

            @Override
            protected Paiement newEntity() {
                return new Paiement();
            }

            @Override
            protected void mapForCreate(Paiement entity, PaiementRequest request) {
                PaiementMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
        entity.setCourse(findOptional(courseRepository, request.courseId(), "Course"));
        entity.setCommande(findOptional(commandeRepository, request.commandeId(), "Commande"));
            }

            @Override
            protected void mapForUpdate(Paiement entity, PaiementRequest request) {
                PaiementMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
        entity.setCourse(findOptional(courseRepository, request.courseId(), "Course"));
        entity.setCommande(findOptional(commandeRepository, request.commandeId(), "Commande"));
            }

            @Override
            protected PaiementResource toResource(Paiement entity) {
                return PaiementMapper.toResource(entity);
            }
        }
