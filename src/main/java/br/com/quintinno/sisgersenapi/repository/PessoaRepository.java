package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.configuration.QueryXMLComponent;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.mapper.PessoaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PessoaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryXMLComponent queryXMLComponent;

    public static final String PESSOA_CREATE = "PESSOA_CREATE";
    public static final String PESSOA_FINDALL = "PESSOA_FINDALL";
    public static final String PESSOA_FINDONE_CODIGO = "PESSOA_FINDONE_CODIGO";

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        String query = queryXMLComponent.recuperarQuery(PESSOA_CREATE);
        this.jdbcTemplate.update(query, pessoaDomain.getCategoria(), pessoaDomain.getNome());
        return pessoaDomain;
    }

    public List<PessoaDomain> findAll() {
        List<PessoaDomain> pessoaDomainList = new ArrayList<>();
        String query = queryXMLComponent.recuperarQuery(PESSOA_FINDALL);
        jdbcTemplate.query(query, (resultSet, rowNum) -> {
            PessoaDomain pessoaDomain = PessoaDomain.getPessoaDomain(resultSet);
            pessoaDomainList.add(pessoaDomain);
            return pessoaDomain;
        });
        return pessoaDomainList;
    }

    public PessoaDomain findOne(Long codigo) {
        return this.jdbcTemplate.queryForObject(queryXMLComponent.recuperarQuery(PESSOA_FINDONE_CODIGO), new PessoaRowMapper(), codigo);
    }

}
