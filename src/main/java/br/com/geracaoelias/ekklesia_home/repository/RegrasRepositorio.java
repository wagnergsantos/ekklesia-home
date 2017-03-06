package br.com.geracaoelias.ekklesia_home.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.geracaoelias.ekklesia_home.model.Regra;

@RepositoryRestResource(exported = false)
public interface RegrasRepositorio extends CrudRepository<Regra, Long> {
    
    public List<String> findByNome(String nome);
	
}