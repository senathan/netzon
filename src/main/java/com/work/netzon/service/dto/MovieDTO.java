package com.work.netzon.service.dto;

import com.work.netzon.config.Constants;

import com.work.netzon.domain.Authority;
import com.work.netzon.domain.User;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
public class MovieDTO {

    private Long id;

    private String primaryTitle;

    private String originalTitle;

    private Set<TitleCrewDTO> titleCrews = new HashSet<TitleCrewDTO>();

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Set<TitleCrewDTO> getTitleCrews() {
        return titleCrews;
    }

    public void setTitleCrews(Set<TitleCrewDTO> titleCrews) {
        this.titleCrews = titleCrews;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "MovieDTO{" +
            "id=" + id +
            ", primaryTitle='" + primaryTitle + '\'' +
            ", originalTitle='" + originalTitle + '\'' +
            ", titleCrews=" + titleCrews +
            '}';
    }
}
