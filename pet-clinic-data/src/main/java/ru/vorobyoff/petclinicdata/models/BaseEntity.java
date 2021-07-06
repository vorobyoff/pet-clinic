package ru.vorobyoff.petclinicdata.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}