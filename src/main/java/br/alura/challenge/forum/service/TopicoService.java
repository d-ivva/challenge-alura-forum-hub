package br.alura.challenge.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.alura.challenge.forum.domain.Topico;
import br.alura.challenge.forum.dto.DadosAtualizacaoTopico;
import br.alura.challenge.forum.dto.DadosDetalhamentoTopico;
import br.alura.challenge.forum.dto.DadosListagemTopico;
import br.alura.challenge.forum.dto.DadosTopico;
import br.alura.challenge.forum.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;

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

    public Page<DadosListagemTopico> listarTopicos(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    public DadosDetalhamentoTopico detalharTopico(Long id) {
        Topico topicoDetalhado = repository.getReferenceById(id);
        
        return new DadosDetalhamentoTopico(topicoDetalhado);
    }

    @Transactional
    public DadosDetalhamentoTopico atualizarTopico(Long id, DadosAtualizacaoTopico dados) {
        var topicoOptional = repository.findById(id);
        if (!topicoOptional.isPresent())
            throw new EntityNotFoundException("Tópico não encontrado.");
        var topico = topicoOptional.get();
        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoTopico(topico); 
    }

    @Transactional
    public void excluirTopico(Long id) {
        var topico = repository.findById(id);
        if (!topico.isPresent()){
            throw new EntityNotFoundException("Tópico não encontrado.");
        }
        repository.deleteById(id);
    }
}