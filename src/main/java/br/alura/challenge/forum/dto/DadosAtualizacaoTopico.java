package br.alura.challenge.forum.dto;

import br.alura.challenge.forum.domain.Topico;

public record DadosAtualizacaoTopico(

    String titulo,
    String curso,
    String mensagem
) {

    public DadosAtualizacaoTopico(Topico topico){
        this(topico.getTitulo(), 
        topico.getCurso(), 
        topico.getMensagem());
    }

}
