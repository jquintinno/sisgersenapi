package br.com.quintinno.sisgersenapi.mapper;

import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CofreRowMapper implements RowMapper<CofreDomain> {

    @Override
    public CofreDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return CofreDomain.getCofreDomain(resultSet);
    }

}
