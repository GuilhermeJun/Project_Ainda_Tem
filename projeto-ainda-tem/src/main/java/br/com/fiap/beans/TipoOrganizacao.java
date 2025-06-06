package br.com.fiap.beans;

public class TipoOrganizacao {
    private int codigo;
    private String nome;

    public TipoOrganizacao() {
        super();
    }

    public TipoOrganizacao(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "TipoOrganizacao{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
