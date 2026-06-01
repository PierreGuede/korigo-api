package com.korigo.api.shared.services;

import java.util.List;
import java.util.UUID;

public interface CrudOperations<REQ, RES> {

    RES create(REQ request);

    RES update(UUID id, REQ request);

    RES findById(UUID id);

    List<RES> findAll();

    void delete(UUID id);
}
