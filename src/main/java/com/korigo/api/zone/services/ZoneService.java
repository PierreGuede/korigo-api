package com.korigo.api.zone.services;

        import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.zone.dtos.ZoneRequest;
import com.korigo.api.zone.entities.Zone;
import com.korigo.api.zone.mappings.ZoneMapper;
import com.korigo.api.zone.repositories.ZoneRepository;
import com.korigo.api.zone.resources.ZoneResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class ZoneService extends AbstractCrudService<Zone, ZoneRequest, ZoneResource> {

            private final ZoneRepository repository;

            public ZoneService(ZoneRepository repository) {
                super(repository, "Zone");
                this.repository = repository;

            }

            @Override
            protected Zone newEntity() {
                return new Zone();
            }

            @Override
            protected void mapForCreate(Zone entity, ZoneRequest request) {
                ZoneMapper.updateEntity(entity, request);
            }

            @Override
            protected void mapForUpdate(Zone entity, ZoneRequest request) {
                ZoneMapper.updateEntity(entity, request);
            }

            @Override
            protected ZoneResource toResource(Zone entity) {
                return ZoneMapper.toResource(entity);
            }
        }
