package com.ipayecoding.springjpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.sql.results.spi.LoadContexts;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

            @Id
            @GeneratedValue
            private Integer id;

            private LocalDateTime createdAt;

            private LocalDateTime lastModifiedAt;

            private String createdBy;

            private String lastModifiedBy;
}
