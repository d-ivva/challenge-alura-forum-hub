package br.alura.challenge.forum.domain;

import java.time.LocalDate;

import br.alura.challenge.forum.dto.DadosTopico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String resposta;
    private boolean status;
    private LocalDate dataCriacao;

    public Topico(DadosTopico dados) {
        this.autor = dados.autor();
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.status = false;
        this.dataCriacao = LocalDate.now();
    }

}
