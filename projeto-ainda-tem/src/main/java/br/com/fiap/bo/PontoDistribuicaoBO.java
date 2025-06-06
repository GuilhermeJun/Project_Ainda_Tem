package br.com.fiap.bo;

import br.com.fiap.beans.PontoDistribuicao;
import br.com.fiap.dao.PontoDistribuicaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PontoDistribuicaoBO {
    PontoDistribuicaoDAO pontoDistribuicaoDAO;

    public ArrayList<PontoDistribuicao> selecionarBO() throws SQLException, ClassNotFoundException {
        pontoDistribuicaoDAO = new PontoDistribuicaoDAO();
        return (ArrayList<PontoDistribuicao>) pontoDistribuicaoDAO.selecionar();
    }

    public void inserirBO(PontoDistribuicao pontoDistribuicao) throws SQLException, ClassNotFoundException {
        pontoDistribuicaoDAO = new PontoDistribuicaoDAO();
        pontoDistribuicaoDAO.inserir(pontoDistribuicao);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        pontoDistribuicaoDAO = new PontoDistribuicaoDAO();
        pontoDistribuicaoDAO.deletar(codigo);
    }
}
