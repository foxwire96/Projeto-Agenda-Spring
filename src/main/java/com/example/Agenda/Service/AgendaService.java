package com.example.Agenda.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Agenda.Entity.Agenda;
import com.example.Agenda.Repository.AgendaRepository;

@Service
public class AgendaService {
	private AgendaRepository agendaRepository;
	
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}
	
	public List<Agenda> create(Agenda agenda) {
		agendaRepository.save(agenda);
		return list();
	}
	
	public List<Agenda> list() {
		agendaRepository.findAll();
		return list();
	}
	
	public List<Agenda> update(Agenda agenda) {
		agendaRepository.save(agenda);
		return list();
	}
	
	public List<Agenda> delete(Long id) {
		agendaRepository.deleteById(id);
		return list();
	}

}
