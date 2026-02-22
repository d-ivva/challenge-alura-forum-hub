package br.alura.challenge.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.alura.challenge.forum.domain.Topico;
import br.alura.challenge.forum.dto.DadosTopico;
import br.alura.challenge.forum.repository.TopicoRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public void cadastrarTopico(DadosTopico dados){
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new IllegalArgumentException("Tópico já existente.");
        } else {
            Topico novoTopico = new Topico(dados);
            repository.save(novoTopico);
        }

    }

}
