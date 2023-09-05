package br.com.quintinno.sisgersenapi.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    @JoinColumn(name = "ID_PESSOA", nullable = false)
    private PessoaDomain pessoaDomain;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificador;

    @Column(name = "CHAVE", nullable = false)
    private String chave;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDate dataAtualizacao;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private LocalDate dataVencimento;

    public CofreDomain() { }

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

    public PessoaDomain getPessoaDomain() {
        return pessoaDomain;
    }

    public void setPessoaDomain(PessoaDomain pessoaDomain) {
        this.pessoaDomain = pessoaDomain;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
