package com.work.netzon.service.dto;

import com.work.netzon.config.Constants;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
public class TitleCrewDTO {

    private String primaryName;

    private String category;

    private Long birthYear;

    private Long deathYear;

    private String primaryProfession;


    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "TitleCrewDTO{" +
            "primaryName='" + primaryName + '\'' +
            ", category='" + category + '\'' +
            ", birthYear=" + birthYear +
            ", deathYear=" + deathYear +
            ", primaryProfession='" + primaryProfession + '\'' +
            '}';
    }
}
