package br.com.geracaoelias.ekklesia_home.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cosium.spring.data.jpa.entity.graph.repository.JpaEntityGraphRepository;

import br.com.geracaoelias.ekklesia_home.model.Igreja;


public interface IgrejaRepositorio extends JpaEntityGraphRepository<Igreja, Long> {	
    Page<Igreja> findByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable p);		
}
