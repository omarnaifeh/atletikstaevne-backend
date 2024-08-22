package com.omar1907.atletikstaevne.repositories;

import com.omar1907.atletikstaevne.models.Event;
import com.omar1907.atletikstaevne.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    default Event addEvent(Event event) {

        var newEvent = new Event();

        var timeSlot = new TimeSlot();

        timeSlot.setDate(LocalDate.now());
        timeSlot.setStartTime(LocalTime.of(0, 0, 0));
        timeSlot.setEndTime(LocalTime.of(0, 0, 0));

        //var savedTimeSlot = timeSlotRepository.addTimeSlot(timeSlot);

        newEvent.setName(event.getName());
        newEvent.setMinimumDuration(LocalTime.of(0, 0, 0));
        newEvent.setParticipantsGender(event.getParticipantsGender());
        newEvent.setParticipantAgeGroup(event.getParticipantAgeGroup());
        newEvent.setMaximumParticipants(event.getMaximumParticipants());
        newEvent.setTimeSlot(event.getTimeSlot());
        newEvent.setDiscipline(event.getDiscipline());
        newEvent.setTrack(event.getTrack());

        return save(newEvent);
    }

    default Optional<Event> updateEvent(Long id, Event eventDetails) {
        return findById(id).map(event -> {
            event.setMinimumDuration(eventDetails.getMinimumDuration());
            event.setParticipantsGender(eventDetails.getParticipantsGender());
            event.setParticipantAgeGroup(eventDetails.getParticipantAgeGroup());
            event.setMaximumParticipants(eventDetails.getMaximumParticipants());
            event.setTimeSlot(eventDetails.getTimeSlot());
            event.setDiscipline(eventDetails.getDiscipline());
            event.setTrack(eventDetails.getTrack());
            return save(event);
        });
    }

    default void deleteEvent(Long id) {
        deleteById(id);
    }



}
