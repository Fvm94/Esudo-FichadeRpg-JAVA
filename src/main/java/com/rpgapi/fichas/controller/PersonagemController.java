package com.rpgapi.fichas.controller;

import com.rpgapi.fichas.dto.PersonagemRequestDTO;
import com.rpgapi.fichas.dto.PersonagemResponseDTO;
import com.rpgapi.fichas.model.Atributo;
import com.rpgapi.fichas.model.Personagem;
import com.rpgapi.fichas.service.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService service;

     public PersonagemController(PersonagemService service){
         this.service = service;
     }

     @PostMapping
    public ResponseEntity<PersonagemResponseDTO> criarPersonagem(@RequestBody @Valid PersonagemRequestDTO dto){

         List<Atributo> atributosCalculados = dto.atributos().stream()
                 .map(a -> new Atributo(a.nome(), a.valor(), (int) Math.floor((a.valor() - 10) /2.0f)))
                 .toList();

         Personagem novoPersonagem = new Personagem((dto.nome()), dto.classe(), dto.nivel(),atributosCalculados);
         Personagem salvoPersonagem = service.salvar(novoPersonagem);

         return ResponseEntity.status(HttpStatus.CREATED).body(new PersonagemResponseDTO(salvoPersonagem));
     }

     @GetMapping("/{id}")

    public ResponseEntity<PersonagemResponseDTO> buscarPorId(@PathVariable Long id){
         Personagem personagem = service.buscarPorId(id);
         return ResponseEntity.ok(new PersonagemResponseDTO(personagem));
     }

     @GetMapping
    public ResponseEntity<List<PersonagemResponseDTO>> listarPersonagens(){
         List<PersonagemResponseDTO> lista = service.listarTodos().stream()
                 .map(PersonagemResponseDTO::new)
                 .toList();
         return ResponseEntity.ok(lista);
     }


}
