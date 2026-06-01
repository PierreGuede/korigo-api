package com.korigo.api.role.mappings;

        import com.korigo.api.role.dtos.RoleRequest;
import com.korigo.api.role.entities.Role;
import com.korigo.api.role.resources.RoleResource;

        public final class RoleMapper {

            private RoleMapper() {
            }

            public static Role toEntity(RoleRequest request) {
                var entity = new Role();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(Role entity, RoleRequest request) {
                entity.setNom(request.nom());
        entity.setDescription(request.description());
            }

            public static RoleResource toResource(Role entity) {
                return new RoleResource(
                    entity.getId(),
            entity.getNom(),
            entity.getDescription(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
