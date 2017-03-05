package br.com.geracaoelias.ekklesia_home.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.hibernate.Hibernate;

import com.google.common.base.MoreObjects;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Entity<ID>
{    

    private static final long serialVersionUID = -6182333182152696568L;
    
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
}
