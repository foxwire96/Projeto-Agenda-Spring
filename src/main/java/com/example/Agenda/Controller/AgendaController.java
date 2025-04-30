package com.example.Agenda.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Agenda.Entity.Agenda;
import com.example.Agenda.Service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	private AgendaService agendaService;
	
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}
	
	@PostMapping
	List<Agenda> create(@RequestBody Agenda agenda)  {
		return agendaService.create(agenda);
	}
	
	@GetMapping
	List<Agenda> list() {
		return agendaService.list();
	}
	
	@PutMapping
	List<Agenda> update(@RequestBody Agenda agenda) {
		return agendaService.update(agenda);
		
	}
	
	@DeleteMapping("{id}")
	List<Agenda> delete(@PathVariable("id") Long id) {
		return agendaService.delete(id);
	}
}
