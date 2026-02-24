package br.alura.challenge.forum.domain;

import java.time.LocalDateTime;

import br.alura.challenge.forum.dto.DadosAtualizacaoTopico;
import br.alura.challenge.forum.dto.DadosTopico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table (name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String mensagem;
    private String curso;
    @Transient
    private String resposta;
    @Column(columnDefinition = "tinyint")
    private boolean status;
    private LocalDateTime dataCriacao;

    public Topico(DadosTopico dados) {
        this.autor = dados.autor();
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.status = false;
        this.dataCriacao = LocalDateTime.now();
    }

   public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
    if (dados.titulo() != null) {
        this.titulo = dados.titulo();
    }
    if (dados.mensagem() != null) {
        this.mensagem = dados.mensagem();
    }
    if (dados.curso() != null) {
        this.curso = dados.curso();
    }
}
}
