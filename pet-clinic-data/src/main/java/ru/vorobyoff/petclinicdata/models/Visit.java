package ru.vorobyoff.petclinicdata.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "visit")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}