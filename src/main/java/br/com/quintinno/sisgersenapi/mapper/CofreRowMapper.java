package br.com.quintinno.sisgersenapi.mapper;

import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CofreRowMapper implements RowMapper<CofreDomain> {

    @Override
    public CofreDomain mapRow(ResultSet resultSet, int rowNum) throws SQLException {
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
        return cofreDomain;
    }

}
