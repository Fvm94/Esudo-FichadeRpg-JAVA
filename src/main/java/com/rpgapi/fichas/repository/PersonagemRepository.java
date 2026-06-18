package com.rpgapi.fichas.repository;

import com.rpgapi.fichas.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}
