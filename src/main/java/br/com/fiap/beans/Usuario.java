package br.com.fiap.beans;

public class Usuario {
    private int codigo;
    private String nome;
    private int idade;
    private String telefone;
    private String email;
    private String senha;
    private String tipoUsuario;
    private Organizacao organizacao;

    public Usuario() {
        super();
    }

    public Usuario(int codigo, String nome, int idade, String telefone, String email, String senha, String tipoUsuario, Organizacao organizacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.organizacao = organizacao;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Organizacao getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(Organizacao organizacao) {
        this.organizacao = organizacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", organizacao=" + organizacao +
                '}';
    }
}
