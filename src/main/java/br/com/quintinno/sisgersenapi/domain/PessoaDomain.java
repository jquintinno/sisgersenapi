package br.com.quintinno.sisgersenapi.domain;

import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "TB_PESSOA")
public class PessoaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CODIGO", nullable = false)
    private UUID codigo;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    public PessoaDomain() { }

    public PessoaDomain(UUID codigo) {
        this.codigo = codigo;
    }

    public static PessoaDomain getPessoaDomain(ResultSet resultSet) throws SQLException {
        PessoaDomain pessoaDomain = new PessoaDomain();
            pessoaDomain.setCodigo(UUID.fromString(resultSet.getString("CODIGO")));
            pessoaDomain.setCategoria(resultSet.getString("CATEGORIA"));
            pessoaDomain.setNome(resultSet.getString("NOME"));
        return pessoaDomain;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
