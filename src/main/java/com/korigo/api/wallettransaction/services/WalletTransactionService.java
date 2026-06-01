package com.korigo.api.wallettransaction.services;

        import com.korigo.api.shared.services.AbstractCrudService;
import com.korigo.api.utilisateur.repositories.UtilisateurRepository;
import com.korigo.api.wallettransaction.dtos.WalletTransactionRequest;
import com.korigo.api.wallettransaction.entities.WalletTransaction;
import com.korigo.api.wallettransaction.mappings.WalletTransactionMapper;
import com.korigo.api.wallettransaction.repositories.WalletTransactionRepository;
import com.korigo.api.wallettransaction.resources.WalletTransactionResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        @Service
        @Transactional
        public class WalletTransactionService extends AbstractCrudService<WalletTransaction, WalletTransactionRequest, WalletTransactionResource> {

            private final WalletTransactionRepository repository;
    private final UtilisateurRepository utilisateurRepository;

            public WalletTransactionService(WalletTransactionRepository repository, UtilisateurRepository utilisateurRepository) {
                super(repository, "WalletTransaction");
                this.repository = repository;
                this.utilisateurRepository = utilisateurRepository;
            }

            @Override
            protected WalletTransaction newEntity() {
                return new WalletTransaction();
            }

            @Override
            protected void mapForCreate(WalletTransaction entity, WalletTransactionRequest request) {
                WalletTransactionMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected void mapForUpdate(WalletTransaction entity, WalletTransactionRequest request) {
                WalletTransactionMapper.updateEntity(entity, request);
        entity.setUtilisateur(findRequired(utilisateurRepository, request.utilisateurId(), "Utilisateur"));
            }

            @Override
            protected WalletTransactionResource toResource(WalletTransaction entity) {
                return WalletTransactionMapper.toResource(entity);
            }
        }
