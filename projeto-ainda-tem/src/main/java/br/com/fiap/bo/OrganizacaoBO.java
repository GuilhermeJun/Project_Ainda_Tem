package br.com.fiap.bo;

import br.com.fiap.beans.Organizacao;
import br.com.fiap.dao.OrganizacaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrganizacaoBO {
    OrganizacaoDAO organizacaoDAO;

    public void inserirBO(Organizacao organizacao) throws SQLException, ClassNotFoundException {
        organizacaoDAO = new OrganizacaoDAO();
        organizacaoDAO.inserir(organizacao);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        organizacaoDAO = new OrganizacaoDAO();
        organizacaoDAO.deletar(codigo);
    }

    public ArrayList<Organizacao> selecionarBO() throws SQLException, ClassNotFoundException {
        organizacaoDAO = new OrganizacaoDAO();
        return (ArrayList<Organizacao>) organizacaoDAO.selecionar();
    }
}
