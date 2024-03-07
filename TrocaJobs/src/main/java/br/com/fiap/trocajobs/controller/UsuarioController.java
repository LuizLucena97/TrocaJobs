package br.com.fiap.trocajobs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trocajobs.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Usuario> repository = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario novoUsuario){
        log.info("Criando um novo usuário");

        for (Usuario usuario : repository) {
            if (usuario.id().equals(novoUsuario.id())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }

        repository.add(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("Buscando usuário com id {}", id);

        for(Usuario usuario: repository){
            if (usuario.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        log.info("Atualizando usuário com id {}", id);

        for (int i = 0; i < repository.size(); i++) {
            Usuario usuario = repository.get(i);
            if (usuario.id().equals(id)) {
                repository.set(i, usuarioAtualizado);
                return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        log.info("Excluindo usuário com id {}", id);

        Optional<Usuario> usuarioOpt = repository.stream()
                .filter(usuario -> usuario.id().equals(id))
                .findFirst();

        if (usuarioOpt.isPresent()) {
            repository.remove(usuarioOpt.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}