package br.com.fiap.beans;

import java.sql.Timestamp;

public class Recurso {
    private int codigo;
    private Timestamp dataCadastro;
    private int quantDisponivel;
    private String status;
    private Usuario usuario;
    private Item item;
    private Localizacao localizacao;

    public Recurso() {
        super();
    }

    public Recurso(int codigo, Timestamp dataCadastro, int quantDisponivel, String status, Usuario usuario, Item item, Localizacao localizacao) {
        this.codigo = codigo;
        this.dataCadastro = dataCadastro;
        this.quantDisponivel = quantDisponivel;
        this.status = status;
        this.usuario = usuario;
        this.item = item;
        this.localizacao = localizacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "codigo=" + codigo +
                ", dataCadastro=" + dataCadastro +
                ", quantDisponivel=" + quantDisponivel +
                ", status='" + status + '\'' +
                ", usuario=" + usuario +
                ", item=" + item +
                ", localizacao=" + localizacao +
                '}';
    }
}
