package com.omar1907.atletikstaevne.models;

import com.omar1907.atletikstaevne.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private LocalTime minimumDuration = LocalTime.of(0, 0, 0);

    @Column(nullable = false)
    private String participantAgeGroup;

    @Column(nullable = false)
    private Integer maximumParticipants;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Gender participantsGender;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "timeSlot_id")
    private TimeSlot timeSlot;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "track_id")
    private Track track;

}
