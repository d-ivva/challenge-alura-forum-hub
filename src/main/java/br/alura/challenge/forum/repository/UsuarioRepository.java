package br.alura.challenge.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.alura.challenge.forum.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public UserDetails findByLogin(String login);

}
