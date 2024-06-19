package com.ipayecoding.springjpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.security.DrbgParameters;
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {



        private String lectureName;

        @ManyToOne
        @JoinColumn(name="section_id")
        private Section section;

        @OneToOne
        @JoinColumn(name= "resource_id")
        private Resources resources;
}
