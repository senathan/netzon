package com.work.netzon.web.rest;

import com.work.netzon.domain.TitleRatings;
import com.work.netzon.repository.TitleRatingsRepository;
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
 * REST controller for managing {@link com.work.netzon.domain.TitleRatings}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TitleRatingsResource {

    private final Logger log = LoggerFactory.getLogger(TitleRatingsResource.class);

    private static final String ENTITY_NAME = "titleRatings";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TitleRatingsRepository titleRatingsRepository;

    public TitleRatingsResource(TitleRatingsRepository titleRatingsRepository) {
        this.titleRatingsRepository = titleRatingsRepository;
    }

    /**
     * {@code POST  /title-ratings} : Create a new titleRatings.
     *
     * @param titleRatings the titleRatings to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleRatings, or with status {@code 400 (Bad Request)} if the titleRatings has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/title-ratings")
    public ResponseEntity<TitleRatings> createTitleRatings(@RequestBody TitleRatings titleRatings) throws URISyntaxException {
        log.debug("REST request to save TitleRatings : {}", titleRatings);
        if (titleRatings.getId() != null) {
            throw new BadRequestAlertException("A new titleRatings cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TitleRatings result = titleRatingsRepository.save(titleRatings);
        return ResponseEntity.created(new URI("/api/title-ratings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /title-ratings} : Updates an existing titleRatings.
     *
     * @param titleRatings the titleRatings to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titleRatings,
     * or with status {@code 400 (Bad Request)} if the titleRatings is not valid,
     * or with status {@code 500 (Internal Server Error)} if the titleRatings couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/title-ratings")
    public ResponseEntity<TitleRatings> updateTitleRatings(@RequestBody TitleRatings titleRatings) throws URISyntaxException {
        log.debug("REST request to update TitleRatings : {}", titleRatings);
        if (titleRatings.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TitleRatings result = titleRatingsRepository.save(titleRatings);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, titleRatings.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /title-ratings} : get all the titleRatings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of titleRatings in body.
     */
    @GetMapping("/title-ratings")
    public List<TitleRatings> getAllTitleRatings() {
        log.debug("REST request to get all TitleRatings");
        return titleRatingsRepository.findAll();
    }

    /**
     * {@code GET  /title-ratings/:id} : get the "id" titleRatings.
     *
     * @param id the id of the titleRatings to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the titleRatings, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/title-ratings/{id}")
    public ResponseEntity<TitleRatings> getTitleRatings(@PathVariable Long id) {
        log.debug("REST request to get TitleRatings : {}", id);
        Optional<TitleRatings> titleRatings = titleRatingsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(titleRatings);
    }

    /**
     * {@code DELETE  /title-ratings/:id} : delete the "id" titleRatings.
     *
     * @param id the id of the titleRatings to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/title-ratings/{id}")
    public ResponseEntity<Void> deleteTitleRatings(@PathVariable Long id) {
        log.debug("REST request to delete TitleRatings : {}", id);
        titleRatingsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
