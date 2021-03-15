package com.work.netzon.repository;

import com.work.netzon.domain.NameBasics;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NameBasics entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NameBasicsRepository extends JpaRepository<NameBasics, Long> {
}
