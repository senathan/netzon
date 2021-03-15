package com.work.netzon.web.rest;

import com.work.netzon.domain.NameBasics;
import com.work.netzon.repository.NameBasicsRepository;
import com.work.netzon.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.work.netzon.domain.NameBasics}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class NameBasicsResource {

    private final Logger log = LoggerFactory.getLogger(NameBasicsResource.class);

    private static final String ENTITY_NAME = "nameBasics";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NameBasicsRepository nameBasicsRepository;

    public NameBasicsResource(NameBasicsRepository nameBasicsRepository) {
        this.nameBasicsRepository = nameBasicsRepository;
    }

    /**
     * {@code POST  /name-basics} : Create a new nameBasics.
     *
     * @param nameBasics the nameBasics to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new nameBasics, or with status {@code 400 (Bad Request)} if the nameBasics has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/name-basics")
    public ResponseEntity<NameBasics> createNameBasics(@RequestBody NameBasics nameBasics) throws URISyntaxException {
        log.debug("REST request to save NameBasics : {}", nameBasics);
        if (nameBasics.getId() != null) {
            throw new BadRequestAlertException("A new nameBasics cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NameBasics result = nameBasicsRepository.save(nameBasics);
        return ResponseEntity.created(new URI("/api/name-basics/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /name-basics} : Updates an existing nameBasics.
     *
     * @param nameBasics the nameBasics to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated nameBasics,
     * or with status {@code 400 (Bad Request)} if the nameBasics is not valid,
     * or with status {@code 500 (Internal Server Error)} if the nameBasics couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/name-basics")
    public ResponseEntity<NameBasics> updateNameBasics(@RequestBody NameBasics nameBasics) throws URISyntaxException {
        log.debug("REST request to update NameBasics : {}", nameBasics);
        if (nameBasics.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NameBasics result = nameBasicsRepository.save(nameBasics);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, nameBasics.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /name-basics} : get all the nameBasics.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of nameBasics in body.
     */
    @GetMapping("/name-basics")
    public List<NameBasics> getAllNameBasics() {
        log.debug("REST request to get all NameBasics");
        return nameBasicsRepository.findAll();
    }

    /**
     * {@code GET  /name-basics/:id} : get the "id" nameBasics.
     *
     * @param id the id of the nameBasics to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the nameBasics, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/name-basics/{id}")
    public ResponseEntity<NameBasics> getNameBasics(@PathVariable Long id) {
        log.debug("REST request to get NameBasics : {}", id);
        Optional<NameBasics> nameBasics = nameBasicsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(nameBasics);
    }

    /**
     * {@code DELETE  /name-basics/:id} : delete the "id" nameBasics.
     *
     * @param id the id of the nameBasics to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/name-basics/{id}")
    public ResponseEntity<Void> deleteNameBasics(@PathVariable Long id) {
        log.debug("REST request to delete NameBasics : {}", id);
        nameBasicsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
