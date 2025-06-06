package br.com.fiap.beans;

import java.sql.Timestamp;

public class Solicitacao {
    private int id;
    private int quantidade;
    private Timestamp dataSolicitacao;
    private String status;
    private Usuario usuario;
    private Estoque estoque;
    private Recurso recurso;

    public Solicitacao() {
        super();
    }

    public Solicitacao(int id, int quantidade, Timestamp dataSolicitacao, String status, Usuario usuario, Estoque estoque, Recurso recurso) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
        this.usuario = usuario;
        this.estoque = estoque;
        this.recurso = recurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Timestamp getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Timestamp dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", dataSolicitacao=" + dataSolicitacao +
                ", status='" + status + '\'' +
                ", usuario=" + usuario +
                ", estoque=" + estoque +
                ", recurso=" + recurso +
                '}';
    }
}
