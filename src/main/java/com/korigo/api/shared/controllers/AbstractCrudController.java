package com.korigo.api.shared.controllers;

import com.korigo.api.shared.services.CrudOperations;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public abstract class AbstractCrudController<REQ, RES> {

    private final CrudOperations<REQ, RES> service;

    protected AbstractCrudController(CrudOperations<REQ, RES> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RES> create(@Valid @RequestBody REQ request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public RES update(@PathVariable UUID id, @Valid @RequestBody REQ request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public RES findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<RES> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
