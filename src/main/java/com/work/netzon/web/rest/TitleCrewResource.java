package com.work.netzon.web.rest;

import com.work.netzon.domain.TitleCrew;
import com.work.netzon.repository.TitleCrewRepository;
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
 * REST controller for managing {@link com.work.netzon.domain.TitleCrew}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TitleCrewResource {

    private final Logger log = LoggerFactory.getLogger(TitleCrewResource.class);

    private static final String ENTITY_NAME = "titleCrew";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TitleCrewRepository titleCrewRepository;

    public TitleCrewResource(TitleCrewRepository titleCrewRepository) {
        this.titleCrewRepository = titleCrewRepository;
    }

    /**
     * {@code POST  /title-crews} : Create a new titleCrew.
     *
     * @param titleCrew the titleCrew to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleCrew, or with status {@code 400 (Bad Request)} if the titleCrew has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/title-crews")
    public ResponseEntity<TitleCrew> createTitleCrew(@RequestBody TitleCrew titleCrew) throws URISyntaxException {
        log.debug("REST request to save TitleCrew : {}", titleCrew);
        if (titleCrew.getId() != null) {
            throw new BadRequestAlertException("A new titleCrew cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TitleCrew result = titleCrewRepository.save(titleCrew);
        return ResponseEntity.created(new URI("/api/title-crews/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /title-crews} : Updates an existing titleCrew.
     *
     * @param titleCrew the titleCrew to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titleCrew,
     * or with status {@code 400 (Bad Request)} if the titleCrew is not valid,
     * or with status {@code 500 (Internal Server Error)} if the titleCrew couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/title-crews")
    public ResponseEntity<TitleCrew> updateTitleCrew(@RequestBody TitleCrew titleCrew) throws URISyntaxException {
        log.debug("REST request to update TitleCrew : {}", titleCrew);
        if (titleCrew.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TitleCrew result = titleCrewRepository.save(titleCrew);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, titleCrew.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /title-crews} : get all the titleCrews.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of titleCrews in body.
     */
    @GetMapping("/title-crews")
    public List<TitleCrew> getAllTitleCrews() {
        log.debug("REST request to get all TitleCrews");
        return titleCrewRepository.findAll();
    }

    /**
     * {@code GET  /title-crews/:id} : get the "id" titleCrew.
     *
     * @param id the id of the titleCrew to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the titleCrew, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/title-crews/{id}")
    public ResponseEntity<TitleCrew> getTitleCrew(@PathVariable Long id) {
        log.debug("REST request to get TitleCrew : {}", id);
        Optional<TitleCrew> titleCrew = titleCrewRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(titleCrew);
    }

    /**
     * {@code DELETE  /title-crews/:id} : delete the "id" titleCrew.
     *
     * @param id the id of the titleCrew to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/title-crews/{id}")
    public ResponseEntity<Void> deleteTitleCrew(@PathVariable Long id) {
        log.debug("REST request to delete TitleCrew : {}", id);
        titleCrewRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
