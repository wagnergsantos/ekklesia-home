package br.com.geracaoelias.ekklesia_home.model;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Access(AccessType.FIELD)
@Entity
public class Regra extends BaseEntity<Long>
{

    private static final long serialVersionUID = 1L;

    private String nome;
    
    @ManyToMany(mappedBy = "regras")
    private Set<Usuario> usuarios;

    public Regra()
    {

    }
    @Id
    @Access(AccessType.PROPERTY)
    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;

    }

}
