package fiap.com.br.flashshopco.controller;

import java.util.List;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import fiap.com.br.flashshopco.model.Produto;
import fiap.com.br.flashshopco.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/produto")
@Slf4j
public class ProdutoController {
    
    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<Produto> index(){
        log.info("Dados retornados com sucesso");
        return repository.findAll();
    };

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto create (@RequestBody Produto produto){
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto>get(@PathVariable Long id){
        log.info("Dados retornados com sucesso: {}", id);
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    };


    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Produto update (@PathVariable Long id, @RequestBody Produto produto){
        verificarSeExisteCategoria(id);
        produto.setId(id);
        return repository.save(produto);
    }

    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando produto: {}", id);
        verificarSeExisteCategoria(id);
        repository.deleteById(id);
    }
    
    private void verificarSeExisteCategoria(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "id do produto não encontrado"));
    }
}
