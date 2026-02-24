package br.alura.challenge.forum.controller;

import br.alura.challenge.forum.domain.Usuario;
import br.alura.challenge.forum.dto.DadosAutenticacao;
import br.alura.challenge.forum.dto.DadosTokenJWT;
import br.alura.challenge.forum.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var usuarioLogado = (Usuario) authentication.getPrincipal();
        var tokenJWT = tokenService.gerarToken(usuarioLogado);
        
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}