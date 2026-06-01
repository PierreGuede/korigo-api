package com.korigo.api.chauffeur.entities;

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
        @Table(name = "chauffeur")
        public class Chauffeur extends BaseEntity {

            @Column(name = "actif", nullable = false)
    private Boolean actif;

    @Column(name = "statut", nullable = false)
    private String statut;

    @Column(name = "note", nullable = true)
    private Double note;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;
        }
