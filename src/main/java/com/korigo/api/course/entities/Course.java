package com.korigo.api.course.entities;

        import com.korigo.api.chauffeur.entities.Chauffeur;
import com.korigo.api.shared.entities.BaseEntity;
import com.korigo.api.utilisateur.entities.Utilisateur;
import com.korigo.api.vehicule.entities.Vehicule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

        @Getter
        @Setter
        @NoArgsConstructor
        @Entity
        @Table(name = "course")
        public class Course extends BaseEntity {

            @Column(name = "distance_km", nullable = false)
    private Double distanceKm;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "statut", nullable = false)
    private String statut;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = true)
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Utilisateur client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chauffeur_id", nullable = false)
    private Chauffeur chauffeur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;
        }
