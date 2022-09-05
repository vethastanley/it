package com.softwareag.it.service;

import com.softwareag.it.domain.Request;
import com.softwareag.it.repository.RequestRepository;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Request}.
 */
@Service
@Transactional
public class RequestService {

    private final Logger log = LoggerFactory.getLogger(RequestService.class);

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    /**
     * Save a request.
     *
     * @param request the entity to save.
     * @return the persisted entity.
     */
    public Request save(Request request) {
        log.debug("Request to save Request : {}", request);
        return requestRepository.save(request);
    }

    /**
     * Update a request.
     *
     * @param request the entity to save.
     * @return the persisted entity.
     */
    public Request update(Request request) {
        log.debug("Request to save Request : {}", request);
        return requestRepository.save(request);
    }

    /**
     * Partially update a request.
     *
     * @param request the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Request> partialUpdate(Request request) {
        log.debug("Request to partially update Request : {}", request);

        return requestRepository
            .findById(request.getId())
            .map(existingRequest -> {
                if (request.getApplicationID() != null) {
                    existingRequest.setApplicationID(request.getApplicationID());
                }
                if (request.getName() != null) {
                    existingRequest.setName(request.getName());
                }
                if (request.getDoj() != null) {
                    existingRequest.setDoj(request.getDoj());
                }
                if (request.getRole() != null) {
                    existingRequest.setRole(request.getRole());
                }
                if (request.getTeam() != null) {
                    existingRequest.setTeam(request.getTeam());
                }
                if (request.getManager() != null) {
                    existingRequest.setManager(request.getManager());
                }
                if (request.getOrg() != null) {
                    existingRequest.setOrg(request.getOrg());
                }
                if (request.getStatus() != null) {
                    existingRequest.setStatus(request.getStatus());
                }

                return existingRequest;
            })
            .map(requestRepository::save);
    }

    /**
     * Get all the requests.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Request> findAll(Pageable pageable) {
        log.debug("Request to get all Requests");
        return requestRepository.findAll(pageable);
    }

    /**
     * Get one request by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Request> findOne(UUID id) {
        log.debug("Request to get Request : {}", id);
        return requestRepository.findById(id);
    }

    /**
     * Delete the request by id.
     *
     * @param id the id of the entity.
     */
    public void delete(UUID id) {
        log.debug("Request to delete Request : {}", id);
        requestRepository.deleteById(id);
    }
}
