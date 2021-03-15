package com.work.netzon.repository;

import com.work.netzon.domain.TitleRatings;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TitleRatings entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TitleRatingsRepository extends JpaRepository<TitleRatings, Long> {
}
