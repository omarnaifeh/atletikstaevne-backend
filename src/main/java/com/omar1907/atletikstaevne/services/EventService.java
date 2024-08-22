package com.omar1907.atletikstaevne.services;

import com.omar1907.atletikstaevne.models.Event;
import com.omar1907.atletikstaevne.models.TimeSlot;
import com.omar1907.atletikstaevne.repositories.DisciplineRepository;
import com.omar1907.atletikstaevne.repositories.EventRepository;
import com.omar1907.atletikstaevne.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public Event addEvent(Event event) {

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setDate(event.getTimeSlot().getDate());
        timeSlot.setStartTime(event.getTimeSlot().getStartTime());
        timeSlot.setEndTime(event.getTimeSlot().getEndTime());

        var savedTimeSlot = timeSlotRepository.save(timeSlot);

        var newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setMinimumDuration(event.getMinimumDuration());
        newEvent.setParticipantsGender(event.getParticipantsGender());
        newEvent.setParticipantAgeGroup(event.getParticipantAgeGroup());
        newEvent.setMaximumParticipants(event.getMaximumParticipants());
        newEvent.setTimeSlot(savedTimeSlot);  // Set the saved TimeSlot
        newEvent.setDiscipline(event.getDiscipline());
        newEvent.setTrack(event.getTrack());

        newEvent.setDiscipline(event.getDiscipline());
        newEvent.setTrack(event.getTrack());

        return eventRepository.save(newEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

}
