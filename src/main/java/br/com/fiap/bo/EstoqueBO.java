package br.com.fiap.bo;

import br.com.fiap.beans.Estoque;
import br.com.fiap.dao.EstoqueDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EstoqueBO {
    EstoqueDAO estoqueDAO;

    public ArrayList<Estoque> selecionarBO() throws SQLException, ClassNotFoundException {
        estoqueDAO = new EstoqueDAO();
        return (ArrayList<Estoque>) estoqueDAO.selecionar();
    }

    public void inserirBO(Estoque estoque) throws SQLException, ClassNotFoundException {
        estoqueDAO = new EstoqueDAO();
        estoqueDAO.inserir(estoque);
    }

    public void atualizarBO(Estoque estoque) throws SQLException, ClassNotFoundException {
        estoqueDAO = new EstoqueDAO();
        estoqueDAO.atualizar(estoque);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        estoqueDAO = new EstoqueDAO();
        estoqueDAO.deletar(codigo);
    }
}
