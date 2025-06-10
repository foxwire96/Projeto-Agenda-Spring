package com.example.agenda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.Entity.Agenda;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
