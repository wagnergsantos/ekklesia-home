package br.com.geracaoelias.ekklesia_home.model;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.geracaoelias.ekklesia_home.model.converter.EstadoConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Igreja.default", attributeNodes = { @NamedAttributeNode("membros") }) })
@Entity
public class Igreja {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(min = 4, max = 70)
	private String nome;

	@Email
	private String email;

	@NotEmpty
	@Size(min = 4, max = 70)
	private String dirigente;
	
	@NotEmpty
	@Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataFundacao;

	@Column(length = 14)
	private String cnpj;

	@Column(length = 11)
	private String telefone;

	@Column(name = "estado_sigla", length = 2, nullable = false)
	@Convert(converter = EstadoConverter.class)
	private Estado estado;

	private Integer cep;

	@Size(min = 4, max = 60)
	private String bairro;

	@Size(min = 4, max = 60)
	private String cidade;

	private String site;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=Igreja.class)
	private Igreja sede;

	@OneToMany(mappedBy = "igreja", targetEntity = Membro.class)
	private Set<Membro> membros;

	@Override
	public int hashCode() {
		try {
			final int prime = 31;
			int result = 1;

			Method m = getClass().getDeclaredMethod("getId");
			Object obj = m.invoke(this, (Object[]) null);
			if (obj != null) {
				int tempHashCode = obj.hashCode();
				result = prime * result + tempHashCode;
			}

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Resolve a questão do 'instanceof/isAssignableFrom' devido ao proxy do
	 * Hibernate.
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			if (obj == null) {
				return false;
			}
			if ((this == obj)) {
				return true;
			}

			// resolve comparacao entre entidades transientes e entidades com
			// proxy
			Class<?> c1 = Hibernate.getClass(this);
			Class<?> c2 = Hibernate.getClass(obj);

			if (!c1.equals(c2)) {
				return false;
			}

			Method m = getClass().getDeclaredMethod("getId");

			Object myValue = m.invoke(this, (Object[]) null);
			Object otherValue = m.invoke(obj, (Object[]) null);

			if (myValue != null && otherValue == null)
				return false;

			if (myValue == null && otherValue != null)
				return false;

			if (myValue != null && otherValue != null) {
				if (!myValue.equals(otherValue))
					return false;
			}

			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
