package com.work.netzon.service;

import com.work.netzon.repository.TitleBasicsRepository;
import com.work.netzon.service.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Service for sending emails.
 * <p>
 * We use the {@link Async} annotation to send emails asynchronously.
 */
@Service
public class SearchService {

    private final Logger log = LoggerFactory.getLogger(SearchService.class);

    private static final String USER = "user";

    private static final String BASE_URL = "baseUrl";

    private final TitleBasicsRepository titleBasicsRepository;

    public SearchService(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    public Optional<MovieDTO> getMoviesByTitle(String title){

        //The outcome should be related information to that title, including cast and crew

//        List<MovieDTO> movieDTO = titleBasicsRepository.findAllByTitle(title);

        return null;
    }

    public Optional<MovieDTO> getTopRatedMovies(String genre){

        //The outcome should be related information to that title, including cast and crew

//        MovieDTO movieDTO = titleBasicsRepository.findAllByGenre(genre);
        return null;

    }

}
