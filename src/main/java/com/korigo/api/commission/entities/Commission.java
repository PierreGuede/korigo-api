package com.korigo.api.commission.entities;

        import com.korigo.api.course.entities.Course;
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
        @Table(name = "commission")
        public class Commission extends BaseEntity {

            @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "pourcentage", nullable = false)
    private Double pourcentage;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
        }
