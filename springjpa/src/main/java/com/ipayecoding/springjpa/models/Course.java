package com.ipayecoding.springjpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity {


    private String name;

    private String description;
    @ManyToMany
    @JoinTable(
            name= "authors_courses",
            joinColumns= {
                    @JoinColumn(name="course_id")
            },
            inverseJoinColumns= {
                    @JoinColumn(name="author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy= "course")
    private List<Section> sections;
}
