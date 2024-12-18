package com.crio.springsecuritydemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.springsecuritydemo.model.Video;


public interface VideoRepository extends MongoRepository<Video, String>{
    Video findByTitle(String title);
    Video findByDirector(String director);
    Video findByGenre(String title);
}
