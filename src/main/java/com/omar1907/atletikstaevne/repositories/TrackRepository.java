package com.omar1907.atletikstaevne.repositories;

import com.omar1907.atletikstaevne.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    default List<Track> getAllTracks() {
        return findAll();
    }

}
