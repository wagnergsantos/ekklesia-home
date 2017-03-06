package br.com.geracaoelias.ekklesia_home.model;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Access(AccessType.FIELD)
@Entity
@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = "Usuario.default", attributeNodes = {
        @NamedAttributeNode("regras")
    })
})
public class Usuario extends BaseEntity<Long>
{

    private static final long serialVersionUID = 1L;

    @Column(name = "username")
    private String            username;

    @Column(name = "password")
    private String            password;

    @Column(name = "enabled")
    private Boolean           enabled;
    
    @ManyToMany
    @JoinTable( 
        name = "usuarios_regras", 
        joinColumns = @JoinColumn(
          name = "usuario_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "regra_id", referencedColumnName = "id")) 
    private Set<Regra> regras;

    public Usuario()
    {

    }

    public Usuario(Usuario user)
    {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
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
