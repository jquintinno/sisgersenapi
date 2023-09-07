package br.com.quintinno.sisgersenapi.dto;

public class ExceptionResponseDTO {

    private String situacao;

    private String mensagem;

    private String dataHora;

    public ExceptionResponseDTO() { }

    public ExceptionResponseDTO(String situacao, String mensagem, String dataHora) {
        this.situacao = situacao;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

}
