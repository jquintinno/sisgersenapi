package br.com.quintinno.sisgersenapi.domain;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "TB_PESSOA")
public class PessoaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    public PessoaDomain() { }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
