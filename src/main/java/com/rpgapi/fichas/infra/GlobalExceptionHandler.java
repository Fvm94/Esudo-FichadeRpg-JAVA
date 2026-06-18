package com.rpgapi.fichas.infra;

import com.rpgapi.fichas.controller.PersonagemNaoEncontradoException;
import com.rpgapi.fichas.dto.ErroResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonagemNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> objetoNaoEncontrado(
            PersonagemNaoEncontradoException ex,
            HttpServletRequest request) {

        ErroResponse erro = new ErroResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não Encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
