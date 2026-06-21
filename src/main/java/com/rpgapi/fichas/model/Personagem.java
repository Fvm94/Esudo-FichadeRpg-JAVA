package com.rpgapi.fichas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String classe;

    private Integer nivel;

    @ElementCollection
    private List<Atributo> atributos = new ArrayList<>();

    public Personagem() {

    }

    public Personagem(String nome, String classe, Integer nivel, List<Atributo> atributos) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.atributos = atributos;
    }

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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }
}
