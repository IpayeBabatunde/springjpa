package com.ipayecoding.springjpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(
        name = "Author.findByNamedQuery",
        query= "select a from Author a where a.age >= :age"
)
@NamedQuery(
        name= "Author.updateByNamedQuery",
        query= "update Author a set a.age = :age"
)
//  @Table(name="AUTHOR_TBL")
public class Author extends BaseEntity {

     /*(
            strategy= GenerationType.TABLE,
            generator= "author_ig_gen")


    @SequenceGenerator(
            name="author_sequence",
            sequenceName= "author_sequence",
            allocationSize= 1
    )
    @TableGenerator(
            name= "author_ig_gen",
            table= "id_generator",
            pkColumnName= "id_name",
            valueColumnName= "id_value",
            allocationSize= 1
    ) */

    private String firstName;
    private String lastName;

    @Column (
            unique=true,
            nullable = false
    )
    private String email;
    private int age;

//    @ManyToMany (mappedBy= "authors")
//    private List<Course> courses;


}
