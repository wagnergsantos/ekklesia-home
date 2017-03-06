package br.com.geracaoelias.ekklesia_home.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.cosium.spring.data.jpa.entity.graph.repository.JpaEntityGraphRepository;

import br.com.geracaoelias.ekklesia_home.model.Membro;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(path="membros")
public interface MembroRepositorio extends JpaEntityGraphRepository<Membro, Long> {	
	
}
