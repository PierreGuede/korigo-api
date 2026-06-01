package com.korigo.api.course.services;

        import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.course.dtos.CourseRequest;
import com.korigo.api.course.entities.Course;
import com.korigo.api.course.mappings.CourseMapper;
import com.korigo.api.course.repositories.CourseRepository;
import com.korigo.api.course.resources.CourseResource;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import com.korigo.api.vehicule.repositories.VehiculeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class CourseService extends AbstractCrudService<Course, CourseRequest, CourseResource> {

            private final CourseRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final ChauffeurRepository chauffeurRepository;
    private final VehiculeRepository vehiculeRepository;

            public CourseService(CourseRepository repository, UtilisateurRepository utilisateurRepository, ChauffeurRepository chauffeurRepository, VehiculeRepository vehiculeRepository) {
                super(repository, "Course");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
        this.chauffeurRepository = chauffeurRepository;
        this.vehiculeRepository = vehiculeRepository;
            }

            @Override
            protected Course newEntity() {
                return new Course();
            }

            @Override
            protected void mapForCreate(Course entity, CourseRequest request) {
                CourseMapper.updateEntity(entity, request);
        entity.setClient(findRequired(utilisateurRepository, request.clientId(), "Utilisateur"));
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
        entity.setVehicule(findRequired(vehiculeRepository, request.vehiculeId(), "Vehicule"));
            }

            @Override
            protected void mapForUpdate(Course entity, CourseRequest request) {
                CourseMapper.updateEntity(entity, request);
        entity.setClient(findRequired(utilisateurRepository, request.clientId(), "Utilisateur"));
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
        entity.setVehicule(findRequired(vehiculeRepository, request.vehiculeId(), "Vehicule"));
            }

            @Override
            protected CourseResource toResource(Course entity) {
                return CourseMapper.toResource(entity);
            }
        }
