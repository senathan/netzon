package com.work.netzon.web.rest;

import com.work.netzon.domain.TitleBasics;
import com.work.netzon.domain.TitleCrew;
import com.work.netzon.service.SearchService;
import com.work.netzon.service.dto.MovieDTO;
import com.work.netzon.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

/**
 * REST controller for managing {@link TitleCrew}.
 */
@RestController
@RequestMapping("/search")
@Transactional
public class SearchMovieResource {

    private final Logger log = LoggerFactory.getLogger(SearchMovieResource.class);

    private static final String ENTITY_NAME = "search movies";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SearchService searchService;

    public SearchMovieResource(SearchService searchService) {
        this.searchService = searchService;
    }

    /**
     * {@code POST  /title-basics} : Create a new titleBasics.
     * Present the user with endpoint for allowing them to search by movie’s primary title or original title.
     * The outcome should be related information to that title, including cast and crew.
     *
     * @param title the title to search.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleBasics, or with status {@code 400 (Bad Request)} if the titleBasics has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/movie/{title}")
    public ResponseEntity<MovieDTO> getMoviewByTitle(@PathVariable String title) throws URISyntaxException {
        log.debug("REST request to get movies by title : {}", title);
        if (null == title) {
            throw new BadRequestAlertException("invalid movie title", ENTITY_NAME, "title");
        }
        Optional<MovieDTO> result = searchService.getMoviesByTitle(title);
        return ResponseUtil.wrapOrNotFound(result);
    }

    /**
     * {@code POST  /title-basics} : Create a new titleBasics.
     *
     * Top rated movies: Given a query by the user, you must provide what are the top rated movies for a genre
     * (If the user searches horror, then it should show a list of top rated horror movies)
     *
     *
     * @param genre the titleBasics to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleBasics, or with status {@code 400 (Bad Request)} if the titleBasics has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/movie/{genre}")
    public ResponseEntity<MovieDTO> getTopRatedMovies(@RequestBody String genre) throws URISyntaxException {
        log.debug("REST request to get top rated movies by genre : {}", genre);
        if (null == genre) {
            throw new BadRequestAlertException("invalid movie genre", ENTITY_NAME, "genre");
        }
//        MovieDTO result = searchService.getTopRatedMovies(genre);
        return null;
    }

//    /**
//     * {@code POST  /title-basics} : Updates an existing titleBasics.
//     *
//     * @param titleBasics the titleBasics to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titleBasics,
//     * or with status {@code 400 (Bad Request)} if the titleBasics is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the titleBasics couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/title-basics")
//    public ResponseEntity<TitleBasics> updateTitleBasics(@RequestBody TitleBasics titleBasics) throws URISyntaxException {
//        log.debug("REST request to update TitleBasics : {}", titleBasics);
//        if (titleBasics.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        TitleBasics result = titleBasicsRepository.save(titleBasics);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, titleBasics.getId().toString()))
//            .body(result);
//    }
}
