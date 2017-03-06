package br.com.geracaoelias.ekklesia_home.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cosium.spring.data.jpa.entity.graph.repository.JpaEntityGraphRepository;

import br.com.geracaoelias.ekklesia_home.model.Usuario;

@RepositoryRestResource(exported = false)
public interface UsuarioRepositorio extends JpaEntityGraphRepository<Usuario, Long> {	
    Usuario findByUsername(@Param("username") String username);		
}
