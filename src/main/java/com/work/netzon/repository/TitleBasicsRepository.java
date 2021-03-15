package com.work.netzon.repository;

import com.work.netzon.domain.TitleBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the TitleBasics entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasics, Long> {

    @Query("select titleBasics from TitleBasics where (titleBasics.primaryTitle like :title) or  (titleBasics.originalTitle like :title)")
    List<TitleBasics> findAllByTitle(String title);


    @Query("select titleBasics from TitleBasics titleBasics join titleBasics.titleRatings titleRatings where titleBasics.genres like :genres ORDER BY titleRatings.averageRating DESC,titleRatings.numvotes DESC")
    List<TitleBasics> findAllByGenre(String genres);
}
