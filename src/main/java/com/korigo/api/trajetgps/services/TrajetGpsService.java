package com.korigo.api.trajetgps.services;

        import com.korigo.api.course.repositories.CourseRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.trajetgps.dtos.TrajetGpsRequest;
import com.korigo.api.trajetgps.entities.TrajetGps;
import com.korigo.api.trajetgps.mappings.TrajetGpsMapper;
import com.korigo.api.trajetgps.repositories.TrajetGpsRepository;
import com.korigo.api.trajetgps.resources.TrajetGpsResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class TrajetGpsService extends AbstractCrudService<TrajetGps, TrajetGpsRequest, TrajetGpsResource> {

            private final TrajetGpsRepository repository;
    private final CourseRepository courseRepository;

            public TrajetGpsService(TrajetGpsRepository repository, CourseRepository courseRepository) {
                super(repository, "TrajetGps");
                this.repository = repository;
                this.courseRepository = courseRepository;
            }

            @Override
            protected TrajetGps newEntity() {
                return new TrajetGps();
            }

            @Override
            protected void mapForCreate(TrajetGps entity, TrajetGpsRequest request) {
                TrajetGpsMapper.updateEntity(entity, request);
        entity.setCourse(findRequired(courseRepository, request.courseId(), "Course"));
            }

            @Override
            protected void mapForUpdate(TrajetGps entity, TrajetGpsRequest request) {
                TrajetGpsMapper.updateEntity(entity, request);
        entity.setCourse(findRequired(courseRepository, request.courseId(), "Course"));
            }

            @Override
            protected TrajetGpsResource toResource(TrajetGps entity) {
                return TrajetGpsMapper.toResource(entity);
            }
        }
