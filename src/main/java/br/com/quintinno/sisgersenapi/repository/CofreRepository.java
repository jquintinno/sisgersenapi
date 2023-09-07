package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.utility.CriptografiaUtility;
import br.com.quintinno.sisgersenapi.configuration.QueryXMLComponent;
import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.mapper.CofreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static final String COFRE_FINDONE_CHAVE = "COFRE_FINDONE_CHAVE";

    public static final String COFRE_FINDONE_CODIGO = "COFRE_FINDONE_CODIGO";

    public CofreDomain create(CofreDomain cofreDomain) {
        String query = this.queryXMLComponent.recuperarQuery(COFRE_CREATE);
        this.jdbcTemplate.update(query,
                    cofreDomain.getPessoaGerenciadaDomain().getCodigo(), cofreDomain.getPessoaResponsavelDomain().getCodigo(),
                    cofreDomain.getCategoria(), cofreDomain.getTitulo(),
                    cofreDomain.getIdentificador(), CriptografiaUtility.criptografar(cofreDomain.getChave()));
        return cofreDomain;
    }

    public List<CofreDomain> findAll() {
        List<CofreDomain> cofreDomainList = new ArrayList<>();
        String query = this.queryXMLComponent.recuperarQuery(COFRE_FINDALL);
        this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
            CofreDomain cofreDomain = CofreDomain.getCofreDomain(resultSet);
            cofreDomainList.add(cofreDomain);
            return cofreDomain;
        });
        return cofreDomainList;
    }

    public CofreDomain findOne(Long codigo) {
        CofreDomain cofreDomain = this.jdbcTemplate.queryForObject(
                queryXMLComponent.recuperarQuery(COFRE_FINDONE_CODIGO), new CofreRowMapper(), codigo);
        if (cofreDomain == null) {
            return null;
        }
        return cofreDomain;
    }

    public CofreDomain findOne(String chave) {
        CofreDomain cofreDomain = this.jdbcTemplate.queryForObject(
                queryXMLComponent.recuperarQuery(COFRE_FINDONE_CHAVE), new CofreRowMapper(), CriptografiaUtility.criptografar(chave));
        if (cofreDomain == null) {
            return null;
        }
        return cofreDomain;
    }

}
