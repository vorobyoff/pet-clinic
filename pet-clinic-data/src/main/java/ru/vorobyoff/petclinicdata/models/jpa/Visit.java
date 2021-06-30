package ru.vorobyoff.petclinicdata.models.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @Column(name = "pet")
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(final Long id, final LocalDateTime date, final String description, final Pet pet) {
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    protected Visit() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(final Pet pet) {
        this.pet = pet;
    }
}