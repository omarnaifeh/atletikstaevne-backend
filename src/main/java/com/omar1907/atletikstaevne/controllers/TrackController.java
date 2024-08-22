package com.omar1907.atletikstaevne.controllers;

import com.omar1907.atletikstaevne.models.Track;
import com.omar1907.atletikstaevne.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackController {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @GetMapping("/get-all-tracks")
    public List<Track> getAllTracks() {
        System.out.println("TrackController.getAllTracks");
        return trackRepository.getAllTracks();
    }

}
