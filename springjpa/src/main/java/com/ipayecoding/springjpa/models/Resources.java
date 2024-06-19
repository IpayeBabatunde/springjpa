package com.ipayecoding.springjpa.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
// @DiscriminatorColumn(name="resource_type") >> ONLY WITH SINGLE TABLE
public class Resources {

    @Id
    @GeneratedValue

    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name= "lecture_id")
    private Lecture lecture;
}
