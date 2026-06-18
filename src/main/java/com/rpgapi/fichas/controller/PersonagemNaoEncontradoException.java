package com.rpgapi.fichas.controller;

public class PersonagemNaoEncontradoException extends RuntimeException{
    public PersonagemNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
