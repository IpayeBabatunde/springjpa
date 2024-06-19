package com.ipayecoding.springjpa.repositories;

import com.ipayecoding.springjpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

        List<Author> findByNamedQuery(@Param("age") int age);


        // update Author a se.age = where a.id = 1
        @Modifying
        @Transactional
        @Query("update Author a set a.age = :age where a.id= :id")
        int updateAuthor(int age, int id);

    // select *  from author where firstName = 'ali'
        @Modifying
        @Transactional
        List<Author> findAllByFirstName(String fn);

        @Modifying
        @Transactional
        void updateByNamedQuery(@Param("age") int age);

        // select *  from author where firstName = 'al'
        List<Author> findAllByFirstNameIgnoreCase(String fn);

        // select *  from author where firstName = '%al%'
         List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

        // select *  from author where firstName = 'al%'
        List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

        // select *  from author where firstName in ('ali', 'boy', 'dev')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    // select *  from author where firstName = '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

}
