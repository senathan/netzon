package com.work.netzon.repository;

import com.work.netzon.domain.TitleCrew;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TitleCrew entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TitleCrewRepository extends JpaRepository<TitleCrew, Long> {
}
