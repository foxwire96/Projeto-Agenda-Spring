package com.example.agenda.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="agenda")
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="agenda_id")
	private Long id;
	@Column(name="agenda_nome")
	private String nome;
	@Column(name="agenda_data")
	private LocalDateTime data;
	@Column(name="agenda_descricao")
	private String descricao;
	@Column(name="agenda_concluido")
	private int concluido;
	@Column(name="agenda_prioridade")
	private int prioridade;
	@OneToMany(mappedBy = "agenda")
	private Set<Contato> contatos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getConcluido() {
		return concluido;
	}

	public void setConcluido(int concluido) {
		this.concluido = concluido;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
}

