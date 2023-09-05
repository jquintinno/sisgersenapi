package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.configuration.QueryXMLComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PessoaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryXMLComponent pessoaDAO;

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        String query = pessoaDAO.recuperarQuery("CREATE");
        this.jdbcTemplate.update(query, pessoaDomain.getCategoria(), pessoaDomain.getNome());
        return pessoaDomain;
    }

    public List<PessoaDomain> findAll() {
        List<PessoaDomain> pessoaDomainList = new ArrayList<>();
        String query = pessoaDAO.recuperarQuery("FINDALL");
        jdbcTemplate.query(query, (resultSet, rowNum) -> {
            PessoaDomain pessoaDomain = new PessoaDomain();
                pessoaDomain.setCodigo(resultSet.getLong("CODIGO"));
                pessoaDomain.setCategoria(resultSet.getString("CATEGORIA"));
                pessoaDomain.setNome(resultSet.getString("NOME"));
            pessoaDomainList.add(pessoaDomain);
            return pessoaDomain;
        });
        return pessoaDomainList;
    }

}
