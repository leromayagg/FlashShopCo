package fiap.com.br.flashshopco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.flashshopco.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
