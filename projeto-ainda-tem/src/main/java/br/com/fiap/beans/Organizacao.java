package br.com.fiap.beans;

public class Organizacao {
    private int codigo;
    private String nome;
    private String email;
    private String telefone;
    private TipoOrganizacao tipoOrganizacao;

    public Organizacao() {
        super();
    }

    public Organizacao(int codigo, String nome, String email, String telefone, TipoOrganizacao tipoOrganizacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoOrganizacao = tipoOrganizacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoOrganizacao getTipoOrganizacao() {
        return tipoOrganizacao;
    }

    public void setTipoOrganizacao(TipoOrganizacao tipoOrganizacao) {
        this.tipoOrganizacao = tipoOrganizacao;
    }

    @Override
    public String toString() {
        return "Organizacao{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipoOrganizacao=" + tipoOrganizacao +
                '}';
    }
}
