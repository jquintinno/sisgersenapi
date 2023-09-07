package br.com.quintinno.sisgersenapi.domain;

import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "TB_COFRE")
public class CofreDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_GERENCIADA", nullable = false)
    private PessoaDomain pessoaGerenciadaDomain;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_RESPONSAVEL", nullable = false)
    private PessoaDomain pessoaResponsavelDomain;

    @Column(name = "TITULO", unique = true, nullable = false)
    private String titulo;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificador;

    @Column(name = "CHAVE", nullable = false)
    private String chave;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private LocalDateTime dataVencimento;

    public CofreDomain() { }

    public static CofreDomain getCofreDomain(ResultSet resultSet) throws SQLException {
        CofreDomain cofreDomain = new CofreDomain();
        cofreDomain.setCodigo(resultSet.getLong("CODIGO"));
        cofreDomain.setPessoaGerenciadaDomain(new PessoaDomain(UUID.fromString(resultSet.getString("ID_PESSOA_GERENCIADA"))));
        cofreDomain.setPessoaResponsavelDomain(new PessoaDomain(UUID.fromString(resultSet.getString("ID_PESSOA_RESPONSAVEL"))));
        cofreDomain.setCategoria(resultSet.getString("CATEGORIA"));
        cofreDomain.setIdentificador(resultSet.getString("IDENTIFICADOR"));
        cofreDomain.setChave(resultSet.getString("CHAVE"));
        cofreDomain.setTitulo(resultSet.getString("TITULO"));
        cofreDomain.setDataCadastro(resultSet.getDate("DATA_CADASTRO").toLocalDate().atStartOfDay());
        cofreDomain.setDataAtualizacao(resultSet.getDate("DATA_ATUALIZACAO").toLocalDate().atStartOfDay());
        cofreDomain.setDataVencimento(resultSet.getDate("DATA_VENCIMENTO").toLocalDate().atStartOfDay());
        return cofreDomain;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public PessoaDomain getPessoaGerenciadaDomain() {
        return pessoaGerenciadaDomain;
    }

    public void setPessoaGerenciadaDomain(PessoaDomain pessoaGerenciadaDomain) {
        this.pessoaGerenciadaDomain = pessoaGerenciadaDomain;
    }

    public PessoaDomain getPessoaResponsavelDomain() {
        return pessoaResponsavelDomain;
    }

    public void setPessoaResponsavelDomain(PessoaDomain pessoaResponsavelDomain) {
        this.pessoaResponsavelDomain = pessoaResponsavelDomain;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
