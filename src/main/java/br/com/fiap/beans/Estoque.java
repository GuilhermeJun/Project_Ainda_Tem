package br.com.fiap.beans;

import java.sql.Timestamp;

public class Estoque {
    private int codigo;
    private String nome;
    private int quantidade;
    private Timestamp ultimaAtualizacao;
    private Item item;
    private PontoDistribuicao pontoDistribuicao;

    public Estoque() {
        super();
    }

    public Estoque(int codigo, String nome, int quantidade, Timestamp ultimaAtualizacao, Item item, PontoDistribuicao pontoDistribuicao) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.item = item;
        this.pontoDistribuicao = pontoDistribuicao;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PontoDistribuicao getPontoDistribuicao() {
        return pontoDistribuicao;
    }

    public void setPontoDistribuicao(PontoDistribuicao pontoDistribuicao) {
        this.pontoDistribuicao = pontoDistribuicao;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", ultimaAtualizacao=" + ultimaAtualizacao +
                ", item=" + item +
                ", pontoDistribuicao=" + pontoDistribuicao +
                '}';
    }
}
