package br.alura.challenge.forum.dto;

import java.time.LocalDateTime;

import br.alura.challenge.forum.domain.Topico;

public record DadosListagemTopico(
    Long id,
    String titulo,
    String autor,
    String mensagem,
    String curso,
    String resposta,
    boolean status,
    LocalDateTime dataCriacao
) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), 
        topico.getTitulo(), 
        topico.getAutor(), 
        topico.getMensagem(), 
        topico.getCurso(), 
        topico.getResposta(),
        topico.isStatus(), 
        topico.getDataCriacao());
    }
}