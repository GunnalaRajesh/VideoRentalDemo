package com.crio.springsecuritydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.springsecuritydemo.model.Video;
import com.crio.springsecuritydemo.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }


    public Video getVideoById(Long id) throws RuntimeException {
        return videoRepository.findByID(id);
    }
    

    public Video addVideo(Video video) {
        video.setAvailable(true); // Set the availability status to true by default
        return videoRepository.save(video);
    }


    public Video updateVideo(Long id, Video updatedVideo) {
        Video existingVideo = getVideoById(id);
        existingVideo.setTitle(updatedVideo.getTitle());
        existingVideo.setDirector(updatedVideo.getDirector());
        existingVideo.setGenre(updatedVideo.getGenre());
        existingVideo.setAvailable(updatedVideo.isAvailable());
        return videoRepository.save(existingVideo);
    }


    public void deleteVideo(Long id) {
        Video video = getVideoById(id); // Ensures the video exists
        videoRepository.delete(video);
    }
}
