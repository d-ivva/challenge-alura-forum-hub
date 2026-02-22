package br.alura.challenge.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alura.challenge.forum.domain.Topico;
import br.alura.challenge.forum.dto.DadosTopico;
import br.alura.challenge.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrarNovoTopico(@RequestBody DadosTopico dados) {
        Topico novoTopico = new Topico(dados);
        repository.save(novoTopico);
    }

}
