package com.korigo.api.shared.services;

import com.korigo.api.shared.entities.BaseEntity;
import com.korigo.api.shared.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
public abstract class AbstractCrudService<E extends BaseEntity, REQ, RES> implements CrudOperations<REQ, RES> {

    private final JpaRepository<E, UUID> repository;
    private final String resourceName;

    protected AbstractCrudService(JpaRepository<E, UUID> repository, String resourceName) {
        this.repository = repository;
        this.resourceName = resourceName;
    }

    @Override
    public RES create(REQ request) {
        E entity = newEntity();
        mapForCreate(entity, request);
        return toResource(repository.save(entity));
    }

    @Override
    public RES update(UUID id, REQ request) {
        E entity = getEntity(id);
        mapForUpdate(entity, request);
        return toResource(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public RES findById(UUID id) {
        return toResource(getEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RES> findAll() {
        return repository.findAll().stream().map(this::toResource).toList();
    }

    @Override
    public void delete(UUID id) {
        repository.delete(getEntity(id));
    }

    protected E getEntity(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(resourceName + " not found for id " + id));
    }

    protected <T> T findRequired(JpaRepository<T, UUID> relationRepository, UUID id, String resource) {
        if (id == null) {
            throw new ResourceNotFoundException(resource + " id is required");
        }
        return relationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(resource + " not found for id " + id));
    }

    protected <T> T findOptional(JpaRepository<T, UUID> relationRepository, UUID id, String resource) {
        if (id == null) {
            return null;
        }
        return relationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(resource + " not found for id " + id));
    }

    protected abstract E newEntity();

    protected abstract void mapForCreate(E entity, REQ request);

    protected abstract void mapForUpdate(E entity, REQ request);

    protected abstract RES toResource(E entity);
}
