package com.work.netzon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A TitleRatings.
 */
@Entity
@Table(name = "title_ratings")
public class TitleRatings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "numvotes")
    private Long numvotes;

    @Column(name = "average_rating")
    private Float averageRating;

    @ManyToOne
    @JsonIgnoreProperties(value = "titleRatings", allowSetters = true)
    private TitleBasics titleBasics;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumvotes() {
        return numvotes;
    }

    public TitleRatings numvotes(Long numvotes) {
        this.numvotes = numvotes;
        return this;
    }

    public void setNumvotes(Long numvotes) {
        this.numvotes = numvotes;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public TitleRatings averageRating(Float averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public TitleBasics getTitleBasics() {
        return titleBasics;
    }

    public TitleRatings titleBasics(TitleBasics titleBasics) {
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
        if (!(o instanceof TitleRatings)) {
            return false;
        }
        return id != null && id.equals(((TitleRatings) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TitleRatings{" +
            "id=" + getId() +
            ", numvotes=" + getNumvotes() +
            ", averageRating=" + getAverageRating() +
            "}";
    }
}
