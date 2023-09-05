package br.com.quintinno.sisgersenapi.mapper;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRowMapper implements RowMapper<PessoaDomain> {

    @Override
    public PessoaDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        PessoaDomain pessoaDomain = new PessoaDomain();
            pessoaDomain.setCodigo(resultSet.getLong("CODIGO"));
            pessoaDomain.setCategoria(resultSet.getString("CATEGORIA"));
            pessoaDomain.setNome(resultSet.getString("NOME"));
        return pessoaDomain;
    }

}
