package com.example.Agenda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Agenda.Entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
