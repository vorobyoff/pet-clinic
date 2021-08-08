package ru.vorobyoff.petclinicdata.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "pet_type")
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Builder
    public PetType(final Long id, final String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}