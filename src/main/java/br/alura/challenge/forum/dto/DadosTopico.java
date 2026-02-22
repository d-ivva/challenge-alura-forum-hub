package br.alura.challenge.forum.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String autor,
    @NotBlank
    String mensagem,
    @NotBlank
    String curso
) {

}
