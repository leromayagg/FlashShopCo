package fiap.com.br.flashshopco.controller;

import fiap.com.br.flashshopco.model.Produto;
import fiap.com.br.flashshopco.repository.ProdutoRepository;

import java.util.*;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    ProdutoRepository repository;

    // List<Produto> repository = new ArrayList<>();
    
    @GetMapping
    public List<Produto> index(){
        log.info("Dados retornados com sucesso");
        return repository.findAll();
    };

    // @PostMapping
    // public ResponseEntity<Produto>create(@RequestBody Produto produto){
    //     repository.add(produto);
    //     return ResponseEntity.status(201).body(produto);
    // };


    // @GetMapping("{id}")
    // public ResponseEntity<Produto>get(@PathVariable Long id){
    //     log.info("Dados retornados com sucesso: {}", id);
    //     Optional<Produto> produto = repository.stream().filter(c -> c.id().equals(id)).findFirst();
    //     return ResponseEntity.of(produto);
    // };


    // @PutMapping("{id}")
    // public ResponseEntity<Produto>update(@PathVariable Long id, @RequestBody Produto produto){
    //     log.info("Produto atualizada com sucesso: {}", id);
    //     repository.removeIf(c -> c.id().equals(id));
    //     repository.add(produto);
    //     return ResponseEntity.ok(produto);
    // };

    // @DeleteMapping("{id}")
    // public ResponseEntity<Produto>delete(@PathVariable Long id){
    //     log.info("Produto deletado com sucesso: {}", id);
    //     repository.removeIf(c -> c.id().equals(id));
    //     return ResponseEntity.noContent().build();
    // }

}
