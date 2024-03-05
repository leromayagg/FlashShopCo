package fiap.com.br.flashshopco.model;

import java.util.Random;

public record Produto(Long id,String nome, Double valor, String imagem, Integer quantidade){
    
    public Produto(Long id,String nome, Double valor, String imagem, Integer quantidade){
        //var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = Math.abs( new Random().nextLong() );  
        this.nome = nome;  
        this.valor = valor;  
        this.imagem = imagem;  
        this.quantidade = quantidade;  
    }
}
