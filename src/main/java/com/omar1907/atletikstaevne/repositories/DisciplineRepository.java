package com.omar1907.atletikstaevne.repositories;

import com.omar1907.atletikstaevne.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    default List<Discipline> getAllDisciplines() {
        return findAll();
    }

}
