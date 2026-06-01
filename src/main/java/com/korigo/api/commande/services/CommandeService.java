package com.korigo.api.commande.services;

        import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.commande.dtos.CommandeRequest;
import com.korigo.api.commande.entities.Commande;
import com.korigo.api.commande.mappings.CommandeMapper;
import com.korigo.api.commande.repositories.CommandeRepository;
import com.korigo.api.commande.resources.CommandeResource;
import com.korigo.api.restaurant.repositories.RestaurantRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class CommandeService extends AbstractCrudService<Commande, CommandeRequest, CommandeResource> {

            private final CommandeRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final RestaurantRepository restaurantRepository;
    private final ChauffeurRepository chauffeurRepository;

            public CommandeService(CommandeRepository repository, UtilisateurRepository utilisateurRepository, RestaurantRepository restaurantRepository, ChauffeurRepository chauffeurRepository) {
                super(repository, "Commande");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
        this.restaurantRepository = restaurantRepository;
        this.chauffeurRepository = chauffeurRepository;
            }

            @Override
            protected Commande newEntity() {
                return new Commande();
            }

            @Override
            protected void mapForCreate(Commande entity, CommandeRequest request) {
                CommandeMapper.updateEntity(entity, request);
        entity.setClient(findRequired(utilisateurRepository, request.clientId(), "Utilisateur"));
        entity.setRestaurant(findRequired(restaurantRepository, request.restaurantId(), "Restaurant"));
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected void mapForUpdate(Commande entity, CommandeRequest request) {
                CommandeMapper.updateEntity(entity, request);
        entity.setClient(findRequired(utilisateurRepository, request.clientId(), "Utilisateur"));
        entity.setRestaurant(findRequired(restaurantRepository, request.restaurantId(), "Restaurant"));
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected CommandeResource toResource(Commande entity) {
                return CommandeMapper.toResource(entity);
            }
        }
