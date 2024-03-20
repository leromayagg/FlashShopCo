package fiap.com.br.flashshopco.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @Size(min = 3, max = 255)
    private String nome;
    
    @NotBlank @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank 
    private String email;

    @NotBlank
    private String senha;

}
