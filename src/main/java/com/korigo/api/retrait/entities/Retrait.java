package com.korigo.api.retrait.entities;

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
        @Table(name = "retrait")
        public class Retrait extends BaseEntity {

            @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "methode", nullable = false)
    private String methode;

    @Column(name = "statut", nullable = false)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chauffeur_id", nullable = false)
    private Chauffeur chauffeur;
        }
