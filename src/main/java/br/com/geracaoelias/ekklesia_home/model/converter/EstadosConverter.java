package br.com.geracaoelias.ekklesia_home.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_home.model.Estados;

@Converter(autoApply = true)
public class EstadosConverter implements AttributeConverter<Estados, String>
{

    @Override
    public String convertToDatabaseColumn(Estados estado)
    {       
        return estado != null ? estado.getSigla() : null;
    }

    @Override
    public Estados convertToEntityAttribute(String sigla)
    {
        return Estados.fromValue(sigla);
    }

}
