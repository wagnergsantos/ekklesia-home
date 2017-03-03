package br.com.geracaoelias.ekklesia_home.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.google.common.base.MoreObjects;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Entity<ID>
{
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataModificacao;

    @Version
    protected Long version;

    protected ID id;

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("ID", getId()).omitNullValues().toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;

        return prime * result + getId().hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if ((this == obj)) {
            return true;
        }

        // resolve comparacao entre entidades transientes e entidades com proxy
        Class<?> c1 = Hibernate.getClass(this);
        Class<?> c2 = Hibernate.getClass(obj);

        if (!c1.equals(c2)) {
            return false;
        }

        return this.getId().equals(((Entity<?>) obj).getId());
    }
    
    public Date getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao()
    {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao)
    {
        this.dataModificacao = dataModificacao;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
