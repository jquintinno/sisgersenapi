package br.com.quintinno.sisgersenapi.repository;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.sql.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PessoaDAO pessoaDAO;

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        String sql = pessoaDAO.getQuery();
        for (String query : sql.split(PessoaDAO.QUERY_0001)) {
            if (query.trim().startsWith("\n")) {
                this.jdbcTemplate.update(query, pessoaDomain.getCategoria(), pessoaDomain.getNome());
            }
        }
        return pessoaDomain;
    }

}
