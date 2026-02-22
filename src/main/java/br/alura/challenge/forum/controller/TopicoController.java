package br.alura.challenge.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alura.challenge.forum.dto.DadosAtualizacaoTopico;
import br.alura.challenge.forum.dto.DadosDetalhamentoTopico;
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
    public Page<DadosListagemTopico> listarTodosTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return service.listarTopicos(paginacao);
    }

    @GetMapping ("/{id}")
    public DadosDetalhamentoTopico detalharTopicoEspecifico(@PathVariable Long id) {
        return service.detalharTopico(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topicoAtualizado = service.atualizarTopico(id, dados);

        return ResponseEntity.ok(topicoAtualizado);
    }

    /*@DeleteMapping
    public void excluirTopico() {

    }*/

}
