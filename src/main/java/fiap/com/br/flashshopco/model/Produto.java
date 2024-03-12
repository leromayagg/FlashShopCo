package fiap.com.br.flashshopco.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    private Long id;
    private String nome;
    private Double valor;
    private String imagem;
    private Integer quantidade;
}
