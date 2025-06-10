package com.example.agenda.Controller;

import java.util.List;

import com.example.agenda.dto.AgendaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.Entity.Agenda;
import com.example.agenda.Service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	private final AgendaService agendaService;
	
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}
	
	@PostMapping
	public ResponseEntity<Agenda> create(@RequestBody AgendaDto agenda)  {
		return ResponseEntity.ok(agendaService.create(agenda));
	}
	
	@GetMapping
	public ResponseEntity<List<Agenda>> list() {
		return ResponseEntity.ok(agendaService.list());
	}
	
	@PutMapping
	public ResponseEntity<Agenda> update(@RequestBody Agenda agenda) {
		return ResponseEntity.ok(agendaService.update(agenda));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		agendaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
