package com.work.netzon.web.rest;

import com.work.netzon.domain.TitleBasics;
import com.work.netzon.repository.TitleBasicsRepository;
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
 * REST controller for managing {@link com.work.netzon.domain.TitleBasics}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TitleBasicsResource {

    private final Logger log = LoggerFactory.getLogger(TitleBasicsResource.class);

    private static final String ENTITY_NAME = "titleBasics";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TitleBasicsRepository titleBasicsRepository;

    public TitleBasicsResource(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    /**
     * {@code POST  /title-basics} : Create a new titleBasics.
     *
     * @param titleBasics the titleBasics to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleBasics, or with status {@code 400 (Bad Request)} if the titleBasics has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/title-basics")
    public ResponseEntity<TitleBasics> createTitleBasics(@RequestBody TitleBasics titleBasics) throws URISyntaxException {
        log.debug("REST request to save TitleBasics : {}", titleBasics);
        if (titleBasics.getId() != null) {
            throw new BadRequestAlertException("A new titleBasics cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TitleBasics result = titleBasicsRepository.save(titleBasics);
        return ResponseEntity.created(new URI("/api/title-basics/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /title-basics} : Updates an existing titleBasics.
     *
     * @param titleBasics the titleBasics to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titleBasics,
     * or with status {@code 400 (Bad Request)} if the titleBasics is not valid,
     * or with status {@code 500 (Internal Server Error)} if the titleBasics couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/title-basics")
    public ResponseEntity<TitleBasics> updateTitleBasics(@RequestBody TitleBasics titleBasics) throws URISyntaxException {
        log.debug("REST request to update TitleBasics : {}", titleBasics);
        if (titleBasics.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TitleBasics result = titleBasicsRepository.save(titleBasics);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, titleBasics.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /title-basics} : get all the titleBasics.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of titleBasics in body.
     */
    @GetMapping("/title-basics")
    public List<TitleBasics> getAllTitleBasics() {
        log.debug("REST request to get all TitleBasics");
        return titleBasicsRepository.findAll();
    }

    /**
     * {@code GET  /title-basics/:id} : get the "id" titleBasics.
     *
     * @param id the id of the titleBasics to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the titleBasics, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/title-basics/{id}")
    public ResponseEntity<TitleBasics> getTitleBasics(@PathVariable Long id) {
        log.debug("REST request to get TitleBasics : {}", id);
        Optional<TitleBasics> titleBasics = titleBasicsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(titleBasics);
    }

    /**
     * {@code DELETE  /title-basics/:id} : delete the "id" titleBasics.
     *
     * @param id the id of the titleBasics to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/title-basics/{id}")
    public ResponseEntity<Void> deleteTitleBasics(@PathVariable Long id) {
        log.debug("REST request to delete TitleBasics : {}", id);
        titleBasicsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
