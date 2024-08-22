package com.omar1907.atletikstaevne.repositories;

import com.omar1907.atletikstaevne.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    default TimeSlot addTimeSlot(TimeSlot timeSlot) {
        return save(timeSlot);
    }

}
