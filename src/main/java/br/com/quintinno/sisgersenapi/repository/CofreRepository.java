package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.utility.CriptografiaUtility;
import br.com.quintinno.sisgersenapi.configuration.QueryXMLComponent;
import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.mapper.CofreRowMapper;
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

    public static final String COFRE_FINDONE = "COFRE_FINDONE";

    public CofreDomain create(CofreDomain cofreDomain) {
        String query = queryXMLComponent.recuperarQuery(COFRE_CREATE);
        this.jdbcTemplate.update(query,
                    cofreDomain.getPessoaGerenciadaDomain().getCodigo(), cofreDomain.getPessoaResponsavelDomain().getCodigo(),
                    cofreDomain.getCategoria(), cofreDomain.getTitulo(),
                    cofreDomain.getIdentificador(), CriptografiaUtility.criptografar(cofreDomain.getChave()));
        return cofreDomain;
    }

    public List<CofreDomain> findAll() {
        List<CofreDomain> cofreDomainList = new ArrayList<>();
        String query = queryXMLComponent.recuperarQuery(COFRE_FINDALL);
        jdbcTemplate.query(query, (resultSet, rowNum) -> {
            CofreDomain cofreDomain = new CofreDomain();
                cofreDomain.setCodigo(resultSet.getLong("CODIGO"));
                cofreDomain.setPessoaGerenciadaDomain(new PessoaDomain(resultSet.getLong("ID_PESSOA_GERENCIADA")));
                cofreDomain.setPessoaResponsavelDomain(new PessoaDomain(resultSet.getLong("ID_PESSOA_RESPONSAVEL")));
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

    public CofreDomain findOne(String chave) {
        CofreDomain cofreDomain = this.jdbcTemplate.queryForObject(queryXMLComponent.recuperarQuery(COFRE_FINDONE), new CofreRowMapper(), CriptografiaUtility.criptografar(chave));
        if (cofreDomain == null) {
            return null;
        }
        return cofreDomain;
    }

}
