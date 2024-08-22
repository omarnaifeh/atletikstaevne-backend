package com.omar1907.atletikstaevne.controllers;

import com.omar1907.atletikstaevne.models.Event;
import com.omar1907.atletikstaevne.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {

        if (event.getName() == null || event.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Du skal angive et navn for eventen!");
        }

        if (event.getMinimumDuration() == null) {
            return ResponseEntity.badRequest().body("Du skal angive en minimum varighed for eventen!");
        }

        if (event.getParticipantsGender() == null) {
            return ResponseEntity.badRequest().body("Du skal angive et køn for deltagerne!");
        }

        if (event.getParticipantAgeGroup() == null) {
            return ResponseEntity.badRequest().body("Du skal angive en aldersgruppe for deltagerne!");
        }

        if (event.getMaximumParticipants() == 0) {
            return ResponseEntity.badRequest().body("Du skal angive et maksimum antal deltagere!");
        }

        if (event.getTimeSlot() == null) {
            return ResponseEntity.badRequest().body("Du skal angive et tidsrum for eventen!");
        }

        eventService.addEvent(event);

        return ResponseEntity.ok("Event tilføjet!");
    }

    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event slettet!");
    }

    @GetMapping("/get-all-events")
    public Iterable<Event> getAllEvents() {
        System.out.println("EventController.getAllEvents");
        return eventService.getAllEvents();
    }

}
