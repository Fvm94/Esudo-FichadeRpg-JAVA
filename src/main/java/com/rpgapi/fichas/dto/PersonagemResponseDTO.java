package com.rpgapi.fichas.dto;

import com.rpgapi.fichas.model.Personagem;

import java.util.List;

public record PersonagemResponseDTO (
        Long id,
        String nome,
        String classe,
        Integer nivel,
        List<AtributoDTO> atributos
){
    public PersonagemResponseDTO(Personagem personagem) {
        this(
            personagem.getId(),
            personagem.getNome(),
            personagem.getClasse(),
            personagem.getNivel(),
            personagem.getAtributos().stream()
                        .map(a -> new AtributoDTO(a.getNome(), a.getValor(),a.getModificador()))
                        .toList()
        );
    }
}
