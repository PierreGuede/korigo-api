package com.korigo.api.colis.entities;

        import com.korigo.api.commande.entities.Commande;
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
        @Table(name = "colis")
        public class Colis extends BaseEntity {

            @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "poids", nullable = false)
    private Double poids;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;
        }
