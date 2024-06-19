package com.ipayecoding.springjpa.specification;

import com.ipayecoding.springjpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder) -> {
            if (age < 0) {
                return null;
            }
            return builder.equal(root.get("age"), age);


        };
    }

    public static Specification<Author> firstNameLike (String firstName) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder) -> {
            if (firstName == null) {
                return null;
            }
            return builder.like(root.get("firstName"), "%" + firstName + "% ");


        };

    }


}
