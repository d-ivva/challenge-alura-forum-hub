package br.alura.challenge.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alura.challenge.forum.dto.DadosListagemTopico;
import br.alura.challenge.forum.dto.DadosTopico;
import br.alura.challenge.forum.service.TopicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/forum/topicos")
public class TopicoController {

    @Autowired 
    private TopicoService service;

    @PostMapping
    public void cadastrarNovoTopico(@RequestBody @Valid DadosTopico dados) {
        service.cadastrarTopico(dados);
    }

    @GetMapping
    public List<DadosListagemTopico> listarTodosTopicos() {
        return service.listarTopicos();
    }
}
