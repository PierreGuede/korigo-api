package com.korigo.api.role.services;

        import com.korigo.api.role.dtos.RoleRequest;
import com.korigo.api.role.entities.Role;
import com.korigo.api.role.mappings.RoleMapper;
import com.korigo.api.role.repositories.RoleRepository;
import com.korigo.api.role.resources.RoleResource;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class RoleService extends AbstractCrudService<Role, RoleRequest, RoleResource> {

            private final RoleRepository repository;

            public RoleService(RoleRepository repository) {
                super(repository, "Role");
                this.repository = repository;

            }

            @Override
            protected Role newEntity() {
                return new Role();
            }

            @Override
            protected void mapForCreate(Role entity, RoleRequest request) {
                RoleMapper.updateEntity(entity, request);
            }

            @Override
            protected void mapForUpdate(Role entity, RoleRequest request) {
                RoleMapper.updateEntity(entity, request);
            }

            @Override
            protected RoleResource toResource(Role entity) {
                return RoleMapper.toResource(entity);
            }
        }
