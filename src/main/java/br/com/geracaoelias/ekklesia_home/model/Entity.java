package br.com.geracaoelias.ekklesia_home.model;

import java.io.Serializable;

public interface Entity<ID extends Serializable> extends Serializable {
    public ID getId();
    public void setId(ID id);
}
