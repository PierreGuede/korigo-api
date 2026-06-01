package com.korigo.api.promotion.services;

        import com.korigo.api.promotion.dtos.PromotionRequest;
import com.korigo.api.promotion.entities.Promotion;
import com.korigo.api.promotion.mappings.PromotionMapper;
import com.korigo.api.promotion.repositories.PromotionRepository;
import com.korigo.api.promotion.resources.PromotionResource;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class PromotionService extends AbstractCrudService<Promotion, PromotionRequest, PromotionResource> {

            private final PromotionRepository repository;

            public PromotionService(PromotionRepository repository) {
                super(repository, "Promotion");
                this.repository = repository;

            }

            @Override
            protected Promotion newEntity() {
                return new Promotion();
            }

            @Override
            protected void mapForCreate(Promotion entity, PromotionRequest request) {
                PromotionMapper.updateEntity(entity, request);
            }

            @Override
            protected void mapForUpdate(Promotion entity, PromotionRequest request) {
                PromotionMapper.updateEntity(entity, request);
            }

            @Override
            protected PromotionResource toResource(Promotion entity) {
                return PromotionMapper.toResource(entity);
            }
        }
