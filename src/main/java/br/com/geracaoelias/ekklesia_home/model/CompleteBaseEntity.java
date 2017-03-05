package br.com.geracaoelias.ekklesia_home.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class CompleteBaseEntity<ID extends Serializable> extends BaseEntity<ID>
{
    private static final long serialVersionUID = -3323454316609044692L;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataModificacao;

    @Version
    protected Long version;
}
