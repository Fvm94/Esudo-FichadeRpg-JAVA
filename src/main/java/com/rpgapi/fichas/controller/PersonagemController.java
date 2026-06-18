package com.rpgapi.fichas.controller;

import com.rpgapi.fichas.dto.PersonagemRequestDTO;
import com.rpgapi.fichas.model.Personagem;
import com.rpgapi.fichas.service.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService service;

     public PersonagemController(PersonagemService service){
         this.service = service;
     }

     @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody @Valid PersonagemRequestDTO dto){
         Personagem novoPersonagem = new Personagem((dto.nome()), dto.classe(), dto.nivel());

         Personagem salvoPersonagem = service.salvar(novoPersonagem);

         return ResponseEntity.status(HttpStatus.CREATED).body(salvoPersonagem);
     }

     @GetMapping("/{id}")

    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id){
         Personagem personagem = service.buscarPorId(id);
         return ResponseEntity.ok(personagem);
     }


}
