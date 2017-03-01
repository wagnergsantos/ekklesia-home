package br.com.geracaoelias.ekklesia_home.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cosium.spring.data.jpa.entity.graph.repository.JpaEntityGraphRepository;

import br.com.geracaoelias.ekklesia_home.model.Igreja;

@RepositoryRestResource
public interface IgrejaRepositorio extends JpaEntityGraphRepository<Igreja, Long> {	
    Igreja findByNomeContainingIgnoreCase(String nome);		
}
