package fiap.com.br.flashshopco.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @Size(min = 3, max = 255)
    private String nome;

    @Positive
    private Double valor;


    private String imagem;

    
    private Integer quantidade;

}
