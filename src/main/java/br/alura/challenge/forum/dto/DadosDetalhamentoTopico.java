package br.alura.challenge.forum.dto;

import java.time.LocalDate;

import br.alura.challenge.forum.domain.Topico;

public record DadosDetalhamentoTopico(

    Long id,
    String titulo,
    String autor,
    String mensagem,
    String curso,
    String resposta,
    boolean status,
    LocalDate dataCriacao
) {

    public DadosDetalhamentoTopico(Topico topico){
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
