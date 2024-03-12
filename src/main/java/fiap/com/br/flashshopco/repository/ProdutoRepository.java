package fiap.com.br.flashshopco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.flashshopco.model.Produto;;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
