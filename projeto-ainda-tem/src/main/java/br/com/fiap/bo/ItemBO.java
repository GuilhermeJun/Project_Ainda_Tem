package br.com.fiap.bo;

import br.com.fiap.beans.Item;
import br.com.fiap.dao.ItemDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBO {
    ItemDAO itemDAO;

    public void inserirBO(Item item) throws SQLException, ClassNotFoundException {
        itemDAO = new ItemDAO();

        itemDAO.inserir(item);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        itemDAO = new ItemDAO();

        itemDAO.deletar(codigo);
    }

    public ArrayList<Item> selecionarBO() throws SQLException, ClassNotFoundException {
        itemDAO = new ItemDAO();

        return (ArrayList<Item>) itemDAO.selecionar();
    }
}
