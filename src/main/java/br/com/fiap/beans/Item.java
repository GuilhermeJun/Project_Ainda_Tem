package br.com.fiap.beans;

import java.sql.Timestamp;

public class Item {
    private int codigo;
    private String nome;
    private String informacaoAdicional;
    private Timestamp dataValidade;
    private Categoria categoria;

    public Item() {
        super();
    }

    public Item(int codigo, String nome, String informacaoAdicional, Timestamp dataValidade, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.informacaoAdicional = informacaoAdicional;
        this.dataValidade = dataValidade;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public Timestamp getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Timestamp dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", informacaoAdicional='" + informacaoAdicional + '\'' +
                ", dataValidade=" + dataValidade +
                ", categoria=" + categoria +
                '}';
    }
}
