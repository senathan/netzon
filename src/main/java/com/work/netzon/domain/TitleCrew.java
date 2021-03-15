package com.work.netzon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A TitleCrew.
 */
@Entity
@Table(name = "title_crew")
public class TitleCrew implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "directors")
    private String directors;

    @Column(name = "writers")
    private String writers;

    @ManyToOne
    @JsonIgnoreProperties(value = "titleCrews", allowSetters = true)
    private TitleBasics titleBasics;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirectors() {
        return directors;
    }

    public TitleCrew directors(String directors) {
        this.directors = directors;
        return this;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriters() {
        return writers;
    }

    public TitleCrew writers(String writers) {
        this.writers = writers;
        return this;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public TitleBasics getTitleBasics() {
        return titleBasics;
    }

    public TitleCrew titleBasics(TitleBasics titleBasics) {
        this.titleBasics = titleBasics;
        return this;
    }

    public void setTitleBasics(TitleBasics titleBasics) {
        this.titleBasics = titleBasics;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TitleCrew)) {
            return false;
        }
        return id != null && id.equals(((TitleCrew) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TitleCrew{" +
            "id=" + getId() +
            ", directors='" + getDirectors() + "'" +
            ", writers='" + getWriters() + "'" +
            "}";
    }
}
