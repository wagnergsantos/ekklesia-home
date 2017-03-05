package br.com.geracaoelias.ekklesia_home.model;

import java.util.Map;

import br.com.geracaoelias.ekklesia_home.util.EnumUtils;
import lombok.Getter;

@Getter
public enum Estados
{
    /**
     * Nome: Acre, Sigla: AC
     */
    ACRE("Acre", "AC"),
    /**
     * Nome: Alagoas, Sigla: AL
     */
    ALAGOAS("Alagoas", "AL"),
    /**
     * Nome: Amapá, Sigla: AP
     */
    AMAPA("Amapá", "AP"),
    /**
     * Nome: Amazonas, Sigla: AM
     */
    AMAZONAS("Amazonas", "AM"),
    /**
     * Nome: Bahia, Sigla: BA
     */
    BAHIA("Bahia", "BA"),
    /**
     * Nome: Ceará, Sigla: CE
     */
    CEARA("Ceará", "CE"),
    /**
     * Nome: Distrito Federal, Sigla: DF
     */
    DISTRITOFEDERAL("Distrito Federal", "DF"),
    /**
     * Nome: Espírito Santo, Sigla: ES
     */
    ESPIRITOSANTO("Espírito Santo", "ES"),
    /**
     * Nome: Goiás, Sigla: GO
     */
    GOIAS("Goiás", "GO"),
    /**
     * Nome: Maranhão, Sigla: MA
     */
    MARANHAO("Maranhão", "MA"),
    /**
     * Nome: Mato Grosso, Sigla: MT
     */
    MATOGROSSO("Mato Grosso", "MT"),
    /**
     * Nome: Mato Grosso do Sul, Sigla: MS
     */
    MATOGROSSODOSUL("Mato Grosso do Sul", "MS"),
    /**
     * Nome: Minas Gerais, Sigla: MG
     */
    MINASGERAIS("Minas Gerais", "MG"),
    /**
     * Nome: Pará, Sigla: PA
     */
    PARA("Pará", "PA"),
    /**
     * Nome: Paraíba, Sigla: PB
     */
    PARAIBA("Paraíba", "PB"),
    /**
     * Nome: Paraná, Sigla: PR
     */
    PARANA("Paraná", "PR"),
    /**
     * Nome: Pernambuco, Sigla: PE
     */
    PERNAMBUCO("Pernambuco", "PE"),
    /**
     * Nome: Piauí, Sigla: PI
     */
    PIAUI("Piauí", "PI"),
    /**
     * Nome: Rio de Janeiro, Sigla: RJ
     */
    RIODEJANEIRO("Rio de Janeiro", "RJ"),
    /**
     * Nome: Rio Grande do Norte, Sigla: RN
     */
    RIOGRANDEDONORTE("Rio Grande do Norte", "RN"),
    /**
     * Nome: Rio Grande do Sul, Sigla: RS
     */
    RIOGRANDEDOSUL("Rio Grande do Sul", "RS"),
    /**
     * Nome Rondônia, Silga: RO
     */
    RONDONIA("Rondônia", "RO"),
    /**
     * Nome: Roraima, Sigla: RO
     */
    RORAIMA("Roraima", "RR"),
    /**
     * Nome: Santa Catarina, Sigla: SC
     */
    SANTACATARINA("Santa Catarina", "SC"),
    /**
     * Nome: São Paulo, Sigla: SP
     */
    SAOPAULO("São Paulo", "SP"),
    /**
     * Nome: Sergipe, Sigla: SE
     */
    SERGIPE("Sergipe", "SE"),
    /**
     * Nome: Tocantins, Sigla: TO
     */
    TOCANTINS("Tocantins", "TO");

    private static final EnumUtils.EnumProperty<Estados, String> ENUM_PROP;

    private static final Map<String, Estados> LOOKUP_MAP;

    static {
        ENUM_PROP = new EnumUtils.EnumProperty<Estados, String>()
        {

            @Override
            public String getValue(Estados type)
            {
                return type.getSigla();
            }

        };

        LOOKUP_MAP = EnumUtils.createLookup(Estados.class, ENUM_PROP);
    }

    public static Estados fromValue(String sigla)
    {
        return LOOKUP_MAP.get(sigla);
    }

    private String nome;

    private String sigla;

    /**
     * Construtor que recebe nome sigla
     *
     * @param nome
     * @param sigla
     */
    private Estados(String nome, String sigla)
    {
        this.nome = nome;
        this.sigla = sigla;
    }
      
}
