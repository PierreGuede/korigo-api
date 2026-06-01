package com.korigo.api.supportticket.entities;

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
        @Table(name = "support_ticket")
        public class SupportTicket extends BaseEntity {

            @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "statut", nullable = false)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;
        }
