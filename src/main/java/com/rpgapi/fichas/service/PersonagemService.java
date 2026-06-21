package com.rpgapi.fichas.service;


import com.rpgapi.fichas.controller.PersonagemNaoEncontradoException;
import com.rpgapi.fichas.model.Personagem;
import com.rpgapi.fichas.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

   private final  PersonagemRepository repository;

   public PersonagemService(PersonagemRepository repository){
       this.repository = repository;
   }

   public Personagem salvar(Personagem personagem){
       return repository.save(personagem);
   }

   public Personagem buscarPorId(Long id){
       return repository.findById(id)
               .orElseThrow(() ->new PersonagemNaoEncontradoException("Ficha de Personagem com o ID " + id + "não existe."));
   }

   public List<Personagem>listarTodos (){
       return repository.findAll();
   }
}
