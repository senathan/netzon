package com.work.netzon.repository;

import com.work.netzon.domain.TitlePrincipals;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TitlePrincipals entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipals, Long> {
}
