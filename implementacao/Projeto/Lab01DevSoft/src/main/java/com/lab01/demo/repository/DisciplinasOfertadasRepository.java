package com.lab01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab01.demo.entities.DisciplinasOfertadas;

@Repository
public interface DisciplinasOfertadasRepository extends JpaRepository<DisciplinasOfertadas, Long> {
    
}
