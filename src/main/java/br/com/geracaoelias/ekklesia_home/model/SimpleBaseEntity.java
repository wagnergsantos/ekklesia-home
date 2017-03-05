package br.com.geracaoelias.ekklesia_home.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class SimpleBaseEntity<ID extends Serializable> extends BaseEntity<ID>
{
    private static final long serialVersionUID = 8178724443696409889L;
    
    protected String descricao;

}
