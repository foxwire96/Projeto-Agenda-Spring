package com.example.Agenda.Service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agenda.Entity.Agenda;
import com.example.Agenda.Repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;


	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;

	}
	
	public List<Agenda> create(Agenda agenda) {
		agendaRepository.save(agenda);
		return list();
	}
	
	public List<Agenda> list() {
		List<Agenda> lista= agendaRepository.findAll();

		rabbitTemplate.convertAndSend("fila-ecommerce", lista.get(0));

		return lista;
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
