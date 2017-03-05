package br.com.geracaoelias.ekklesia_home.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.geracaoelias.ekklesia_home.model.converter.EstadosConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = "Igreja.default", attributeNodes = {@NamedAttributeNode("membros")})})
@Entity
@Access(AccessType.FIELD)
public class Igreja extends CompleteBaseEntity<Long>
{
    private static final long serialVersionUID = -8546627499827286971L;

    @NotEmpty
    @Size(min = 4, max = 70)
    private String      nome;

    @Email
    private String      email;

    @NotEmpty
    @Size(min = 4, max = 70)
    private String      dirigente;

    @NotEmpty
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date        dataFundacao;

    @Column(length = 14)
    private String      cnpj;

    @Column(length = 11)
    private String      telefone;

    
    @Convert(converter = EstadosConverter.class)
    @Column(name = "estado_sigla", length = 2, nullable = false)    
    private Estados      estado;

    private Integer     cep;

    @Size(min = 4, max = 60)
    private String      bairro;

    @Size(min = 4, max = 60)
    private String      cidade;

    private String      site;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Igreja.class)
    private Igreja      sede;
    
    @OneToMany(mappedBy="igreja", targetEntity=Membro.class)
    private Set<Membro> membros;

    @Id
    @GeneratedValue
    @Access(AccessType.PROPERTY)
    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        super.id = id;        
    }

    }
