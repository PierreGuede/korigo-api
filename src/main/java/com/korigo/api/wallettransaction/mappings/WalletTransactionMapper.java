package com.korigo.api.wallettransaction.mappings;

        import com.korigo.api.wallettransaction.dtos.WalletTransactionRequest;
import com.korigo.api.wallettransaction.entities.WalletTransaction;
import com.korigo.api.wallettransaction.resources.WalletTransactionResource;

        public final class WalletTransactionMapper {

            private WalletTransactionMapper() {
            }

            public static WalletTransaction toEntity(WalletTransactionRequest request) {
                var entity = new WalletTransaction();
                updateEntity(entity, request);
                return entity;
            }

            public static void updateEntity(WalletTransaction entity, WalletTransactionRequest request) {
                entity.setType(request.type());
        entity.setMontant(request.montant());
        entity.setDescription(request.description());
            }

            public static WalletTransactionResource toResource(WalletTransaction entity) {
                return new WalletTransactionResource(
                    entity.getId(),
            entity.getType(),
            entity.getMontant(),
            entity.getDescription(),
            entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
                );
            }
        }
