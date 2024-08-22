package com.omar1907.atletikstaevne.controllers;

import com.omar1907.atletikstaevne.models.Discipline;
import com.omar1907.atletikstaevne.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/discipline")
@CrossOrigin(origins = "http://localhost:3000")
public class DisciplineController {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineController(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping("/get-all-disciplines")
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        System.out.println("DisciplineController.getAllDisciplines");
        return ResponseEntity.ok(disciplineRepository.getAllDisciplines());
    }

}
