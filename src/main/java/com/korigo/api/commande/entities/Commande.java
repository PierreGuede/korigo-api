package com.korigo.api.commande.entities;

        import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.restaurant.entities.Restaurant;
import com.korigo.api.shared.entities.BaseEntity;
import com.korigo.api.utilisateur.entities.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

        @Getter
        @Setter
        @NoArgsConstructor
        @Entity
        @Table(name = "commande")
        public class Commande extends BaseEntity {

            @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "statut", nullable = false)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Utilisateur client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chauffeur_id", nullable = false)
    private Chauffeur chauffeur;
        }
