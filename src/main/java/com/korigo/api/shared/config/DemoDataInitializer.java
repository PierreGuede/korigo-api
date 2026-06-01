package com.korigo.api.shared.config;

import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.promotion.entities.Promotion;
import com.korigo.api.promotion.repositories.PromotionRepository;
import com.korigo.api.restaurant.entities.Restaurant;
import com.korigo.api.restaurant.repositories.RestaurantRepository;
import com.korigo.api.role.entities.Role;
import com.korigo.api.role.repositories.RoleRepository;
import com.korigo.api.utilisateur.entities.Utilisateur;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import com.korigo.api.vehicule.entities.Vehicule;
import com.korigo.api.vehicule.repositories.VehiculeRepository;
import com.korigo.api.zone.entities.Zone;
import com.korigo.api.zone.repositories.ZoneRepository;
import java.time.LocalDateTime;
import java.util.Locale;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoDataInitializer {

    @Bean
    CommandLineRunner demoDataLoader(
        RoleRepository roleRepository,
        UtilisateurRepository utilisateurRepository,
        ChauffeurRepository chauffeurRepository,
        VehiculeRepository vehiculeRepository,
        RestaurantRepository restaurantRepository,
        PromotionRepository promotionRepository,
        ZoneRepository zoneRepository,
        PasswordEncoder passwordEncoder
    ) {
        return args -> {
            final String demoPassword = "KoriGo123!";
            var clientRole = ensureRole(roleRepository, "CLIENT", "Passager et destinataire des services KoriGo.");
            var driverRole = ensureRole(roleRepository, "CHAUFFEUR", "Partenaire de mobilite et de livraison.");
            ensureRole(roleRepository, "ADMIN", "Supervision des operations et du support.");

            if (chauffeurRepository.count() == 0L) {
                var moussa = ensureUser(
                    utilisateurRepository,
                    driverRole,
                    "Moussa D.",
                    "+23562000001",
                    "moussa.driver@korigo.app",
                    demoPassword,
                    passwordEncoder
                );
                var aicha = ensureUser(
                    utilisateurRepository,
                    driverRole,
                    "Aicha M.",
                    "+23562000002",
                    "aicha.driver@korigo.app",
                    demoPassword,
                    passwordEncoder
                );
                var isa = ensureUser(
                    utilisateurRepository,
                    driverRole,
                    "Issa K.",
                    "+23562000003",
                    "issa.driver@korigo.app",
                    demoPassword,
                    passwordEncoder
                );

                var moussaDriver = createDriver(moussa, 4.8, "EN_LIGNE");
                var aichaDriver = createDriver(aicha, 4.9, "EN_LIGNE");
                var isaDriver = createDriver(isa, 4.6, "DISPONIBLE");

                chauffeurRepository.save(moussaDriver);
                chauffeurRepository.save(aichaDriver);
                chauffeurRepository.save(isaDriver);

                vehiculeRepository.save(createVehicle(moussaDriver, "MOTO", "Honda", "CB 125", "TD-125-KG", "Orange"));
                vehiculeRepository.save(createVehicle(aichaDriver, "VOITURE", "Toyota", "Corolla", "TD-302-KG", "Blanc nacre"));
                vehiculeRepository.save(createVehicle(isaDriver, "MOTO", "Yamaha", "Crypton", "TD-481-KG", "Noir"));
            }

            if (utilisateurRepository.findByTelephone("+23562000000").isEmpty()) {
                ensureUser(
                    utilisateurRepository,
                    clientRole,
                    "Compte Demo",
                    "+23562000000",
                    "client.demo@korigo.app",
                    demoPassword,
                    passwordEncoder
                );
            }

            if (utilisateurRepository.findByTelephone("+23562000004").isEmpty()) {
                ensureUser(
                    utilisateurRepository,
                    clientRole,
                    "Pierre M.",
                    "+23562000004",
                    "pierre@gmail.com",
                    demoPassword,
                    passwordEncoder
                );
            }

            if (restaurantRepository.count() == 0L) {
                restaurantRepository.save(createRestaurant("Sahel Grill", "Avenue Charles de Gaulle, N'Djamena", "+235 66 11 22 33"));
                restaurantRepository.save(createRestaurant("KoriGo Express", "Centre-ville, N'Djamena", "+235 66 44 55 66"));
                restaurantRepository.save(createRestaurant("Douceur Tchadienne", "Quartier Moursal, N'Djamena", "+235 63 20 10 10"));
                restaurantRepository.save(createRestaurant("Le Patio du Chari", "Diguel Est, N'Djamena", "+235 62 98 45 18"));
            }

            if (promotionRepository.count() == 0L) {
                var now = LocalDateTime.now();
                promotionRepository.save(createPromotion("WELCOME10", 10.0, now.minusDays(1), now.plusMonths(1)));
                promotionRepository.save(createPromotion("MOTO15", 15.0, now.minusDays(2), now.plusDays(15)));
                promotionRepository.save(createPromotion("LIVRAISON5", 5.0, now.minusDays(3), now.plusDays(10)));
            }

            if (zoneRepository.count() == 0L) {
                zoneRepository.save(createZone("Centre-ville", "URBAIN"));
                zoneRepository.save(createZone("Diguel", "URBAIN"));
                zoneRepository.save(createZone("Moursal", "URBAIN"));
                zoneRepository.save(createZone("Aeroport Hassan Djamous", "STRATEGIQUE"));
            }
        };
    }

    private Role ensureRole(RoleRepository repository, String name, String description) {
        return repository.findByNomIgnoreCase(name)
            .orElseGet(() -> {
                var role = new Role();
                role.setNom(name.toUpperCase(Locale.ROOT));
                role.setDescription(description);
                return repository.save(role);
            });
    }

    private Utilisateur ensureUser(
        UtilisateurRepository repository,
        Role role,
        String name,
        String phone,
        String email,
        String rawPassword,
        PasswordEncoder passwordEncoder
    ) {
        return repository.findByTelephone(phone)
            .map(existingUser -> refreshExistingUser(
                existingUser,
                role,
                name,
                email,
                rawPassword,
                passwordEncoder,
                repository
            ))
            .orElseGet(() -> createUser(
                role,
                name,
                phone,
                email,
                rawPassword,
                passwordEncoder,
                repository
            ));
    }

    private Utilisateur refreshExistingUser(
        Utilisateur user,
        Role role,
        String name,
        String email,
        String rawPassword,
        PasswordEncoder passwordEncoder,
        UtilisateurRepository repository
    ) {
        boolean changed = false;
        if (!name.equals(user.getNom())) {
            user.setNom(name);
            changed = true;
        }
        if (!email.equalsIgnoreCase(user.getEmail())) {
            user.setEmail(email.toLowerCase(Locale.ROOT));
            changed = true;
        }
        if (user.getRole() == null || !role.getId().equals(user.getRole().getId())) {
            user.setRole(role);
            changed = true;
        }
        if (user.getPasswordHash() == null || user.getPasswordHash().isBlank()) {
            user.setPasswordHash(passwordEncoder.encode(rawPassword));
            changed = true;
        }
        return changed ? repository.save(user) : user;
    }

    private Utilisateur createUser(
        Role role,
        String name,
        String phone,
        String email,
        String rawPassword,
        PasswordEncoder passwordEncoder,
        UtilisateurRepository repository
    ) {
        var user = new Utilisateur();
        user.setNom(name);
        user.setTelephone(phone);
        user.setEmail(email.toLowerCase(Locale.ROOT));
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        return repository.save(user);
    }

    private Chauffeur createDriver(Utilisateur user, double note, String status) {
        var chauffeur = new Chauffeur();
        chauffeur.setUtilisateur(user);
        chauffeur.setActif(true);
        chauffeur.setStatut(status);
        chauffeur.setNote(note);
        return chauffeur;
    }

    private Vehicule createVehicle(
        Chauffeur chauffeur,
        String type,
        String marque,
        String modele,
        String immatriculation,
        String couleur
    ) {
        var vehicle = new Vehicule();
        vehicle.setChauffeur(chauffeur);
        vehicle.setType(type);
        vehicle.setMarque(marque);
        vehicle.setModele(modele);
        vehicle.setImmatriculation(immatriculation);
        vehicle.setCouleur(couleur);
        return vehicle;
    }

    private Restaurant createRestaurant(String nom, String adresse, String telephone) {
        var restaurant = new Restaurant();
        restaurant.setNom(nom);
        restaurant.setAdresse(adresse);
        restaurant.setTelephone(telephone);
        return restaurant;
    }

    private Promotion createPromotion(String code, double reduction, LocalDateTime dateDebut, LocalDateTime dateFin) {
        var promotion = new Promotion();
        promotion.setCode(code);
        promotion.setReduction(reduction);
        promotion.setDateDebut(dateDebut);
        promotion.setDateFin(dateFin);
        return promotion;
    }

    private Zone createZone(String nom, String type) {
        var zone = new Zone();
        zone.setNom(nom);
        zone.setType(type);
        return zone;
    }
}
