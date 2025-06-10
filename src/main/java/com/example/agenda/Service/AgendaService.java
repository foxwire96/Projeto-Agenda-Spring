package com.example.agenda.Service;

import java.util.List;

import com.example.agenda.dto.AgendaDto;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agenda.Entity.Agenda;
import com.example.agenda.Repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}
	@Transactional
	public Agenda create(AgendaDto agendaDto) {
		Agenda agenda = new Agenda();
		agenda.setNome(agendaDto.getNome());
		agenda.setDescricao(agendaDto.getDescricao());
		agenda.setData(agendaDto.getData());
		return agendaRepository.save(agenda);
	}
	
	public List<Agenda> list() {
		List<Agenda> lista= agendaRepository.findAll();

		if(!lista.isEmpty()) {
			rabbitTemplate.convertAndSend("fila-milena", lista.get(0));
		}
		return lista;
	}

	public Agenda update(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	public void delete(Long id) {
		agendaRepository.deleteById(id);
	}

}
