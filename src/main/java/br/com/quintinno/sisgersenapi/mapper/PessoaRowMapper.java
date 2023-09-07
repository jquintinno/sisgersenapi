package br.com.quintinno.sisgersenapi.mapper;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PessoaRowMapper implements RowMapper<PessoaDomain> {

    @Override
    public PessoaDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return PessoaDomain.getPessoaDomain(resultSet);
    }

}
