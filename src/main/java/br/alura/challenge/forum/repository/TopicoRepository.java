package br.alura.challenge.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alura.challenge.forum.domain.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    public boolean existsByTituloAndMensagem(String titulo, String mensagem);

}
