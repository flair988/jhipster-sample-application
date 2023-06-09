package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.ProcessLog;
import com.mycompany.myapp.repository.ProcessLogRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ProcessLog}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ProcessLogResource {

    private final Logger log = LoggerFactory.getLogger(ProcessLogResource.class);

    private static final String ENTITY_NAME = "processLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessLogRepository processLogRepository;

    public ProcessLogResource(ProcessLogRepository processLogRepository) {
        this.processLogRepository = processLogRepository;
    }

    /**
     * {@code POST  /process-logs} : Create a new processLog.
     *
     * @param processLog the processLog to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processLog, or with status {@code 400 (Bad Request)} if the processLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-logs")
    public ResponseEntity<ProcessLog> createProcessLog(@RequestBody ProcessLog processLog) throws URISyntaxException {
        log.debug("REST request to save ProcessLog : {}", processLog);
        if (processLog.getId() != null) {
            throw new BadRequestAlertException("A new processLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessLog result = processLogRepository.save(processLog);
        return ResponseEntity
            .created(new URI("/api/process-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-logs/:id} : Updates an existing processLog.
     *
     * @param id the id of the processLog to save.
     * @param processLog the processLog to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processLog,
     * or with status {@code 400 (Bad Request)} if the processLog is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processLog couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-logs/{id}")
    public ResponseEntity<ProcessLog> updateProcessLog(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProcessLog processLog
    ) throws URISyntaxException {
        log.debug("REST request to update ProcessLog : {}, {}", id, processLog);
        if (processLog.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, processLog.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!processLogRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ProcessLog result = processLogRepository.save(processLog);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, processLog.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /process-logs/:id} : Partial updates given fields of an existing processLog, field will ignore if it is null
     *
     * @param id the id of the processLog to save.
     * @param processLog the processLog to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processLog,
     * or with status {@code 400 (Bad Request)} if the processLog is not valid,
     * or with status {@code 404 (Not Found)} if the processLog is not found,
     * or with status {@code 500 (Internal Server Error)} if the processLog couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/process-logs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ProcessLog> partialUpdateProcessLog(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProcessLog processLog
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProcessLog partially : {}, {}", id, processLog);
        if (processLog.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, processLog.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!processLogRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ProcessLog> result = processLogRepository
            .findById(processLog.getId())
            .map(existingProcessLog -> {
                if (processLog.getType() != null) {
                    existingProcessLog.setType(processLog.getType());
                }
                if (processLog.getRequest() != null) {
                    existingProcessLog.setRequest(processLog.getRequest());
                }
                if (processLog.getResponse() != null) {
                    existingProcessLog.setResponse(processLog.getResponse());
                }
                if (processLog.getStatus() != null) {
                    existingProcessLog.setStatus(processLog.getStatus());
                }
                if (processLog.getReason() != null) {
                    existingProcessLog.setReason(processLog.getReason());
                }
                if (processLog.getProcessStartTime() != null) {
                    existingProcessLog.setProcessStartTime(processLog.getProcessStartTime());
                }
                if (processLog.getProcessEndTime() != null) {
                    existingProcessLog.setProcessEndTime(processLog.getProcessEndTime());
                }

                return existingProcessLog;
            })
            .map(processLogRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, processLog.getId().toString())
        );
    }

    /**
     * {@code GET  /process-logs} : get all the processLogs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processLogs in body.
     */
    @GetMapping("/process-logs")
    public List<ProcessLog> getAllProcessLogs() {
        log.debug("REST request to get all ProcessLogs");
        return processLogRepository.findAll();
    }

    /**
     * {@code GET  /process-logs/:id} : get the "id" processLog.
     *
     * @param id the id of the processLog to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processLog, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-logs/{id}")
    public ResponseEntity<ProcessLog> getProcessLog(@PathVariable Long id) {
        log.debug("REST request to get ProcessLog : {}", id);
        Optional<ProcessLog> processLog = processLogRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(processLog);
    }

    /**
     * {@code DELETE  /process-logs/:id} : delete the "id" processLog.
     *
     * @param id the id of the processLog to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-logs/{id}")
    public ResponseEntity<Void> deleteProcessLog(@PathVariable Long id) {
        log.debug("REST request to delete ProcessLog : {}", id);
        processLogRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
