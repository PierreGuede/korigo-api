package com.korigo.api.commission.services;

        import com.korigo.api.commission.dtos.CommissionRequest;
import com.korigo.api.commission.entities.Commission;
import com.korigo.api.commission.mappings.CommissionMapper;
import com.korigo.api.commission.repositories.CommissionRepository;
import com.korigo.api.commission.resources.CommissionResource;
import com.korigo.api.course.repositories.CourseRepository;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class CommissionService extends AbstractCrudService<Commission, CommissionRequest, CommissionResource> {

            private final CommissionRepository repository;
    private final CourseRepository courseRepository;

            public CommissionService(CommissionRepository repository, CourseRepository courseRepository) {
                super(repository, "Commission");
                this.repository = repository;
                this.courseRepository = courseRepository;
            }

            @Override
            protected Commission newEntity() {
                return new Commission();
            }

            @Override
            protected void mapForCreate(Commission entity, CommissionRequest request) {
                CommissionMapper.updateEntity(entity, request);
        entity.setCourse(findRequired(courseRepository, request.courseId(), "Course"));
            }

            @Override
            protected void mapForUpdate(Commission entity, CommissionRequest request) {
                CommissionMapper.updateEntity(entity, request);
        entity.setCourse(findRequired(courseRepository, request.courseId(), "Course"));
            }

            @Override
            protected CommissionResource toResource(Commission entity) {
                return CommissionMapper.toResource(entity);
            }
        }
