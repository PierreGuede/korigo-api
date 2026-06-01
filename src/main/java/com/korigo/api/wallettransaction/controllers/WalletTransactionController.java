package com.korigo.api.wallettransaction.controllers;

import com.korigo.api.wallettransaction.dtos.WalletTransactionRequest;
import com.korigo.api.wallettransaction.resources.WalletTransactionResource;
import com.korigo.api.wallettransaction.services.WalletTransactionService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet-transactions")
public class WalletTransactionController extends AbstractCrudController<WalletTransactionRequest, WalletTransactionResource> {

    public WalletTransactionController(WalletTransactionService service) {
        super(service);
    }
}
