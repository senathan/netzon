package com.work.netzon.web.rest;

import com.work.netzon.domain.TitlePrincipals;
import com.work.netzon.repository.TitlePrincipalsRepository;
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
 * REST controller for managing {@link com.work.netzon.domain.TitlePrincipals}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TitlePrincipalsResource {

    private final Logger log = LoggerFactory.getLogger(TitlePrincipalsResource.class);

    private static final String ENTITY_NAME = "titlePrincipals";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TitlePrincipalsRepository titlePrincipalsRepository;

    public TitlePrincipalsResource(TitlePrincipalsRepository titlePrincipalsRepository) {
        this.titlePrincipalsRepository = titlePrincipalsRepository;
    }

    /**
     * {@code POST  /title-principals} : Create a new titlePrincipals.
     *
     * @param titlePrincipals the titlePrincipals to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titlePrincipals, or with status {@code 400 (Bad Request)} if the titlePrincipals has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/title-principals")
    public ResponseEntity<TitlePrincipals> createTitlePrincipals(@RequestBody TitlePrincipals titlePrincipals) throws URISyntaxException {
        log.debug("REST request to save TitlePrincipals : {}", titlePrincipals);
        if (titlePrincipals.getId() != null) {
            throw new BadRequestAlertException("A new titlePrincipals cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TitlePrincipals result = titlePrincipalsRepository.save(titlePrincipals);
        return ResponseEntity.created(new URI("/api/title-principals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /title-principals} : Updates an existing titlePrincipals.
     *
     * @param titlePrincipals the titlePrincipals to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titlePrincipals,
     * or with status {@code 400 (Bad Request)} if the titlePrincipals is not valid,
     * or with status {@code 500 (Internal Server Error)} if the titlePrincipals couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/title-principals")
    public ResponseEntity<TitlePrincipals> updateTitlePrincipals(@RequestBody TitlePrincipals titlePrincipals) throws URISyntaxException {
        log.debug("REST request to update TitlePrincipals : {}", titlePrincipals);
        if (titlePrincipals.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TitlePrincipals result = titlePrincipalsRepository.save(titlePrincipals);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, titlePrincipals.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /title-principals} : get all the titlePrincipals.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of titlePrincipals in body.
     */
    @GetMapping("/title-principals")
    public List<TitlePrincipals> getAllTitlePrincipals() {
        log.debug("REST request to get all TitlePrincipals");
        return titlePrincipalsRepository.findAll();
    }

    /**
     * {@code GET  /title-principals/:id} : get the "id" titlePrincipals.
     *
     * @param id the id of the titlePrincipals to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the titlePrincipals, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/title-principals/{id}")
    public ResponseEntity<TitlePrincipals> getTitlePrincipals(@PathVariable Long id) {
        log.debug("REST request to get TitlePrincipals : {}", id);
        Optional<TitlePrincipals> titlePrincipals = titlePrincipalsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(titlePrincipals);
    }

    /**
     * {@code DELETE  /title-principals/:id} : delete the "id" titlePrincipals.
     *
     * @param id the id of the titlePrincipals to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/title-principals/{id}")
    public ResponseEntity<Void> deleteTitlePrincipals(@PathVariable Long id) {
        log.debug("REST request to delete TitlePrincipals : {}", id);
        titlePrincipalsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
