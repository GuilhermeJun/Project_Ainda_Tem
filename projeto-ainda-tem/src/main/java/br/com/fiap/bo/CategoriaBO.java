package br.com.fiap.bo;

import br.com.fiap.beans.Categoria;
import br.com.fiap.dao.CategoriaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaBO {
    CategoriaDAO categoriaDAO;

    public ArrayList<Categoria> selecionarBO() throws SQLException, ClassNotFoundException {
        categoriaDAO = new CategoriaDAO();

        return (ArrayList<Categoria>) categoriaDAO.selecionar();
    }
}
