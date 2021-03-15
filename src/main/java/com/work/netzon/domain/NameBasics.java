package com.work.netzon.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A NameBasics.
 */
@Entity
@Table(name = "name_basics")
public class NameBasics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "primary_name")
    private String primaryName;

    @Column(name = "birth_year")
    private Long birthYear;

    @Column(name = "death_year")
    private Long deathYear;

    @Column(name = "primary_profession")
    private String primaryProfession;

    @Column(name = "known_for_titles")
    private String knownForTitles;

    @OneToMany(mappedBy = "titleBasics")
    private Set<TitlePrincipals> titlePrincipals = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public NameBasics primaryName(String primaryName) {
        this.primaryName = primaryName;
        return this;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public NameBasics birthYear(Long birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public NameBasics deathYear(Long deathYear) {
        this.deathYear = deathYear;
        return this;
    }

    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public NameBasics primaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
        return this;
    }

    public void setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public NameBasics knownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
        return this;
    }

    public void setKnownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
    }

    public Set<TitlePrincipals> getTitlePrincipals() {
        return titlePrincipals;
    }

    public NameBasics titlePrincipals(Set<TitlePrincipals> titlePrincipals) {
        this.titlePrincipals = titlePrincipals;
        return this;
    }

    public NameBasics addTitlePrincipals(TitlePrincipals titlePrincipals) {
        this.titlePrincipals.add(titlePrincipals);
        titlePrincipals.setNameBasics(this);
        return this;
    }

    public NameBasics removeTitlePrincipals(TitlePrincipals titlePrincipals) {
        this.titlePrincipals.remove(titlePrincipals);
        titlePrincipals.setNameBasics(null);
        return this;
    }

    public void setTitlePrincipals(Set<TitlePrincipals> titlePrincipals) {
        this.titlePrincipals = titlePrincipals;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NameBasics)) {
            return false;
        }
        return id != null && id.equals(((NameBasics) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NameBasics{" +
            "id=" + getId() +
            ", primaryName='" + getPrimaryName() + "'" +
            ", birthYear=" + getBirthYear() +
            ", deathYear=" + getDeathYear() +
            ", primaryProfession='" + getPrimaryProfession() + "'" +
            ", knownForTitles='" + getKnownForTitles() + "'" +
            "}";
    }
}
