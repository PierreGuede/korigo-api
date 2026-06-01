package com.korigo.api.kycdocument.controllers;

import com.korigo.api.kycdocument.dtos.KycDocumentRequest;
import com.korigo.api.kycdocument.resources.KycDocumentResource;
import com.korigo.api.kycdocument.services.KycDocumentService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kyc-documents")
public class KycDocumentController extends AbstractCrudController<KycDocumentRequest, KycDocumentResource> {

    public KycDocumentController(KycDocumentService service) {
        super(service);
    }
}
