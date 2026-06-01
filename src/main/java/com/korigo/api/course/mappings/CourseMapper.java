package com.korigo.api.course.mappings;

        import com.korigo.api.course.dtos.CourseRequest;
import com.korigo.api.course.entities.Course;
import com.korigo.api.course.resources.CourseResource;

        public final class CourseMapper {

            private CourseMapper() {
            }

            public static Course toEntity(CourseRequest request) {
                var entity = new Course();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Course entity, CourseRequest request) {
                entity.setDistanceKm(request.distanceKm());
        entity.setPrix(request.prix());
        entity.setStatut(request.statut());
        entity.setStartTime(request.startTime());
        entity.setEndTime(request.endTime());
            }

            public static CourseResource toResource(Course entity) {
                return new CourseResource(
                    entity.getId(),
            entity.getDistanceKm(),
            entity.getPrix(),
            entity.getStatut(),
            entity.getStartTime(),
            entity.getEndTime(),
            entity.getClient() != null ? entity.getClient().getId() : null,
            entity.getChauffeur() != null ? entity.getChauffeur().getId() : null,
            entity.getVehicule() != null ? entity.getVehicule().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
