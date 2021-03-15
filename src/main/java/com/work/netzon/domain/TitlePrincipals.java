package com.work.netzon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A TitlePrincipals.
 */
@Entity
@Table(name = "title_principals")
public class TitlePrincipals implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "job")
    private String job;

    @Column(name = "characters")
    private String characters;

    @ManyToOne
    @JsonIgnoreProperties(value = "titlePrincipals", allowSetters = true)
    private TitleBasics titleBasics;

    @ManyToOne
    @JsonIgnoreProperties(value = "titlePrincipals", allowSetters = true)
    private NameBasics nameBasics;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public TitlePrincipals category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public TitlePrincipals job(String job) {
        this.job = job;
        return this;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacters() {
        return characters;
    }

    public TitlePrincipals characters(String characters) {
        this.characters = characters;
        return this;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public TitleBasics getTitleBasics() {
        return titleBasics;
    }

    public TitlePrincipals titleBasics(TitleBasics titleBasics) {
        this.titleBasics = titleBasics;
        return this;
    }

    public void setTitleBasics(TitleBasics titleBasics) {
        this.titleBasics = titleBasics;
    }

    public NameBasics getNameBasics() {
        return nameBasics;
    }

    public TitlePrincipals nameBasics(NameBasics nameBasics) {
        this.nameBasics = nameBasics;
        return this;
    }

    public void setNameBasics(NameBasics nameBasics) {
        this.nameBasics = nameBasics;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TitlePrincipals)) {
            return false;
        }
        return id != null && id.equals(((TitlePrincipals) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TitlePrincipals{" +
            "id=" + getId() +
            ", category='" + getCategory() + "'" +
            ", job='" + getJob() + "'" +
            ", characters='" + getCharacters() + "'" +
            "}";
    }
}
