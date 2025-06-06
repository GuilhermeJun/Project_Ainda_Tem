package br.com.fiap.excecoes;

public class ExcessoesConexao extends Exception{

    public ExcessoesConexao() {
        super();
    }

    public ExcessoesConexao(Exception e) {
        super();
        if (e.getClass().toString().equals("class java.lang.ClassNotFoundException")) {
            System.out.println("Erro no Driver, sem comunicação com o Banco de Dados");
            e.printStackTrace();
        } else if (e.getClass().toString().equals("class java.sql.SQLException")) {
            System.out.println("Informações de acesso incorretas, acesso negado!");
            e.printStackTrace();
        } else {
            System.out.println("Informações de acesso incorretas");
            e.printStackTrace();
        }
    }
}
