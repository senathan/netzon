package com.work.netzon.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A TitleBasics.
 */
@Entity
@Table(name = "title_basics")
public class TitleBasics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "primary_title")
    private String primaryTitle;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "is_adult")
    private Boolean isAdult;

    @Column(name = "start_year")
    private Long startYear;

    @Column(name = "end_year")
    private Long endYear;

    @Column(name = "run_time_minutes")
    private Long runTimeMinutes;

    @Column(name = "genres")
    private String genres;

    @OneToMany(mappedBy = "titleBasics")
    private Set<TitleCrew> titleCrews = new HashSet<>();

    @OneToMany(mappedBy = "titleBasics")
    private Set<TitleRatings> titleRatings = new HashSet<>();

    @OneToMany(mappedBy = "titleBasics")
    private Set<TitlePrincipals> titlePrincipals = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleType() {
        return titleType;
    }

    public TitleBasics titleType(String titleType) {
        this.titleType = titleType;
        return this;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public TitleBasics primaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
        return this;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public TitleBasics originalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Boolean isIsAdult() {
        return isAdult;
    }

    public TitleBasics isAdult(Boolean isAdult) {
        this.isAdult = isAdult;
        return this;
    }

    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    public Long getStartYear() {
        return startYear;
    }

    public TitleBasics startYear(Long startYear) {
        this.startYear = startYear;
        return this;
    }

    public void setStartYear(Long startYear) {
        this.startYear = startYear;
    }

    public Long getEndYear() {
        return endYear;
    }

    public TitleBasics endYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }

    public void setEndYear(Long endYear) {
        this.endYear = endYear;
    }

    public Long getRunTimeMinutes() {
        return runTimeMinutes;
    }

    public TitleBasics runTimeMinutes(Long runTimeMinutes) {
        this.runTimeMinutes = runTimeMinutes;
        return this;
    }

    public void setRunTimeMinutes(Long runTimeMinutes) {
        this.runTimeMinutes = runTimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public TitleBasics genres(String genres) {
        this.genres = genres;
        return this;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Set<TitleCrew> getTitleCrews() {
        return titleCrews;
    }

    public TitleBasics titleCrews(Set<TitleCrew> titleCrews) {
        this.titleCrews = titleCrews;
        return this;
    }

    public TitleBasics addTitleCrew(TitleCrew titleCrew) {
        this.titleCrews.add(titleCrew);
        titleCrew.setTitleBasics(this);
        return this;
    }

    public TitleBasics removeTitleCrew(TitleCrew titleCrew) {
        this.titleCrews.remove(titleCrew);
        titleCrew.setTitleBasics(null);
        return this;
    }

    public void setTitleCrews(Set<TitleCrew> titleCrews) {
        this.titleCrews = titleCrews;
    }

    public Set<TitleRatings> getTitleRatings() {
        return titleRatings;
    }

    public TitleBasics titleRatings(Set<TitleRatings> titleRatings) {
        this.titleRatings = titleRatings;
        return this;
    }

    public TitleBasics addTitleRatings(TitleRatings titleRatings) {
        this.titleRatings.add(titleRatings);
        titleRatings.setTitleBasics(this);
        return this;
    }

    public TitleBasics removeTitleRatings(TitleRatings titleRatings) {
        this.titleRatings.remove(titleRatings);
        titleRatings.setTitleBasics(null);
        return this;
    }

    public void setTitleRatings(Set<TitleRatings> titleRatings) {
        this.titleRatings = titleRatings;
    }

    public Set<TitlePrincipals> getTitlePrincipals() {
        return titlePrincipals;
    }

    public TitleBasics titlePrincipals(Set<TitlePrincipals> titlePrincipals) {
        this.titlePrincipals = titlePrincipals;
        return this;
    }

    public TitleBasics addTitlePrincipals(TitlePrincipals titlePrincipals) {
        this.titlePrincipals.add(titlePrincipals);
        titlePrincipals.setTitleBasics(this);
        return this;
    }

    public TitleBasics removeTitlePrincipals(TitlePrincipals titlePrincipals) {
        this.titlePrincipals.remove(titlePrincipals);
        titlePrincipals.setTitleBasics((TitleBasics) null);
        return this;
    }

    public void setTitlePrincipals(Set<TitlePrincipals> titlePrincipals) {
        this.titlePrincipals = titlePrincipals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TitleBasics)) {
            return false;
        }
        return id != null && id.equals(((TitleBasics) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TitleBasics{" +
            "id=" + getId() +
            ", titleType='" + getTitleType() + "'" +
            ", primaryTitle='" + getPrimaryTitle() + "'" +
            ", originalTitle='" + getOriginalTitle() + "'" +
            ", isAdult='" + isIsAdult() + "'" +
            ", startYear=" + getStartYear() +
            ", endYear=" + getEndYear() +
            ", runTimeMinutes=" + getRunTimeMinutes() +
            ", genres='" + getGenres() + "'" +
            "}";
    }
}
