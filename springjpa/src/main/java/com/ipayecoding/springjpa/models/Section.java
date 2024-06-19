package com.ipayecoding.springjpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.util.List;
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity {


    private String name;

    private int sectionOrder;

    @ManyToOne
    @JoinColumn (name="course_id")
    private Course course;

    @OneToMany (mappedBy= "section")
    private List<Lecture> lectures;
}
