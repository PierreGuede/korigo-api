package com.korigo.api.kycdocument.services;

        import com.korigo.api.chauffeur.repositories.ChauffeurRepository;
import com.korigo.api.kycdocument.dtos.KycDocumentRequest;
import com.korigo.api.kycdocument.entities.KycDocument;
import com.korigo.api.kycdocument.mappings.KycDocumentMapper;
import com.korigo.api.kycdocument.repositories.KycDocumentRepository;
import com.korigo.api.kycdocument.resources.KycDocumentResource;
import com.korigo.api.shared.services.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class KycDocumentService extends AbstractCrudService<KycDocument, KycDocumentRequest, KycDocumentResource> {

            private final KycDocumentRepository repository;
    private final ChauffeurRepository chauffeurRepository;

            public KycDocumentService(KycDocumentRepository repository, ChauffeurRepository chauffeurRepository) {
                super(repository, "KycDocument");
                this.repository = repository;
                this.chauffeurRepository = chauffeurRepository;
            }

            @Override
            protected KycDocument newEntity() {
                return new KycDocument();
            }

            @Override
            protected void mapForCreate(KycDocument entity, KycDocumentRequest request) {
                KycDocumentMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected void mapForUpdate(KycDocument entity, KycDocumentRequest request) {
                KycDocumentMapper.updateEntity(entity, request);
        entity.setChauffeur(findRequired(chauffeurRepository, request.chauffeurId(), "Chauffeur"));
            }

            @Override
            protected KycDocumentResource toResource(KycDocument entity) {
                return KycDocumentMapper.toResource(entity);
            }
        }
