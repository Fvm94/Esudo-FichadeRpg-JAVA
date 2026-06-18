package com.rpgapi.fichas.dto;

import java.time.Instant;

public record ErroResponse (
    Instant timestamp,
    Integer status,
    String erro,
    String mensagem,
    String caminho
    ){}
