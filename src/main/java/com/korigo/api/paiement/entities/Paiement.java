package com.korigo.api.paiement.entities;

        import com.korigo.api.commande.entities.Commande;
import com.korigo.api.course.entities.Course;
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
        @Table(name = "paiement")
        public class Paiement extends BaseEntity {

            @Column(name = "mode", nullable = false)
    private String mode;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "course_id", nullable = true)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "commande_id", nullable = true)
    private Commande commande;
        }
