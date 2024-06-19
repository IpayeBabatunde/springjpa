package com.ipayecoding.springjpa.repositories;

import com.ipayecoding.springjpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
