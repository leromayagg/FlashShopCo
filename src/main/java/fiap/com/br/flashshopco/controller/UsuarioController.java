package fiap.com.br.flashshopco.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import fiap.com.br.flashshopco.model.Usuario;
import fiap.com.br.flashshopco.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class UsuarioController {
    
    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public List<Usuario> index(){
        log.info("Dados retornados com sucesso");
        return repository.findAll();
    };

    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario create (@RequestBody Usuario usuario){
        return repository.save(usuario);
    };


    @GetMapping("{id}")
    public ResponseEntity<Usuario>get(@PathVariable Long id){
        log.info("Dados retornados com sucesso: {}", id);
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    };

    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Usuario update (@PathVariable Long id, @RequestBody Usuario usuario){
        verificarSeExisteCategoria(id);
        usuario.setId(id);
        return repository.save(usuario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando usuario: {}", id);
        verificarSeExisteCategoria(id);
        repository.deleteById(id);
    }


    private void verificarSeExisteCategoria(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "id do usuario não encontrado"));
    }
}
