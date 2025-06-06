package br.com.fiap.beans;

public class PontoDistribuicao {
    private int codigo;
    private String nome;
    private String observacao;
    private Organizacao organizacao;
    private Localizacao localizacao;

    public PontoDistribuicao() {
        super();
    }

    public PontoDistribuicao(int codigo, String nome, String observacao, Organizacao organizacao, Localizacao localizacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.observacao = observacao;
        this.organizacao = organizacao;
        this.localizacao = localizacao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Organizacao getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(Organizacao organizacao) {
        this.organizacao = organizacao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "PontoDistribuicao{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", observacao='" + observacao + '\'' +
                ", organizacao=" + organizacao +
                ", localizacao=" + localizacao +
                '}';
    }
}
