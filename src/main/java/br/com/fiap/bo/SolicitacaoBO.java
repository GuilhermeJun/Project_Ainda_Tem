package br.com.fiap.bo;

import br.com.fiap.beans.Solicitacao;
import br.com.fiap.dao.SolicitacaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SolicitacaoBO {
    SolicitacaoDAO solicitacaoDAO;

    public ArrayList<Solicitacao> selecionarBO() throws SQLException, ClassNotFoundException {
        solicitacaoDAO = new SolicitacaoDAO();
        return (ArrayList<Solicitacao>) solicitacaoDAO.selecionar();
    }

    public void inserirBO(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.inserir(solicitacao);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.deletar(codigo);
    }
}
