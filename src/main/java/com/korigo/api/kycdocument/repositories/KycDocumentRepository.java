package com.korigo.api.kycdocument.repositories;

import com.korigo.api.kycdocument.entities.KycDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KycDocumentRepository extends JpaRepository<KycDocument, UUID> {
}
