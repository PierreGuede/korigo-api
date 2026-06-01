package com.korigo.api.vehicule.entities;

        import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.shared.entities.BaseEntity;
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
        @Table(name = "vehicule")
        public class Vehicule extends BaseEntity {

            @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    @Column(name = "immatriculation", nullable = false)
    private String immatriculation;

    @Column(name = "couleur", nullable = true)
    private String couleur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chauffeur_id", nullable = false)
    private Chauffeur chauffeur;
        }
