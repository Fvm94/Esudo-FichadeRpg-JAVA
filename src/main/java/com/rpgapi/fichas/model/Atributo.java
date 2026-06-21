package com.rpgapi.fichas.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Atributo {
    private String nome;
    private Integer valor;
    private Integer modificador;

    public Atributo(){

    }
    public Atributo(
            String nome,
            Integer valor,
            Integer modificador
    ){
        this.nome = nome;
        this.valor = valor;
        this.modificador = modificador;
    }

    public String getNome() {return nome;}

    public Integer getValor() {return valor;}

    public Integer getModificador() {return modificador;}
}
