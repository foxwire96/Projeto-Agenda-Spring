package com.example.agenda.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contato_id")
    private Long id;
    @Column(name="contato_nome")
    private String nome;
    @Column(name="contato_telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name="agenda_id", nullable = false)
    private Agenda agenda;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
