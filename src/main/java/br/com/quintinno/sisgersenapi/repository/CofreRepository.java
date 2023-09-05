package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.configuration.QueryXMLComponent;
import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CofreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryXMLComponent queryXMLComponent;

    public static final String COFRE_CREATE = "COFRE_CREATE";

    public static final String COFRE_FINDALL = "COFRE_FINDALL";

    public CofreDomain create(CofreDomain cofreDomain) {
        String query = queryXMLComponent.recuperarQuery(COFRE_CREATE);
        this.jdbcTemplate.update(query,
                    cofreDomain.getPessoaDomain().getCodigo(), cofreDomain.getCategoria(), cofreDomain.getTitulo(),
                    cofreDomain.getIdentificador(), cofreDomain.getChave());
        return cofreDomain;
    }

    public List<CofreDomain> findAll() {
        List<CofreDomain> cofreDomainList = new ArrayList<>();
        String query = queryXMLComponent.recuperarQuery(COFRE_FINDALL);
        jdbcTemplate.query(query, (resultSet, rowNum) -> {
            CofreDomain cofreDomain = new CofreDomain();
                cofreDomain.setCodigo(resultSet.getLong("CODIGO"));
                cofreDomain.setPessoaDomain(new PessoaDomain(resultSet.getLong("ID_PESSOA")));
                cofreDomain.setCategoria(resultSet.getString("CATEGORIA"));
                cofreDomain.setIdentificador(resultSet.getString("IDENTIFICADOR"));
                cofreDomain.setChave(resultSet.getString("CHAVE"));
                cofreDomain.setTitulo(resultSet.getString("TITULO"));
                cofreDomain.setDataCadastro(resultSet.getDate("DATA_CADASTRO").toLocalDate());
                cofreDomain.setDataAtualizacao(resultSet.getDate("DATA_ATUALIZACAO").toLocalDate());
                cofreDomain.setDataVencimento(resultSet.getDate("DATA_VENCIMENTO").toLocalDate());
            cofreDomainList.add(cofreDomain);
            return cofreDomain;
        });
        return cofreDomainList;
    }

}
