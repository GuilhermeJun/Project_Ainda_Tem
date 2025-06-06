package br.com.fiap.bo;

import br.com.fiap.beans.Recurso;
import br.com.fiap.dao.RecursoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecursoBO {
    RecursoDAO recursoDAO;

    public ArrayList<Recurso> selecionarBO() throws SQLException, ClassNotFoundException {
        recursoDAO = new RecursoDAO();
        return (ArrayList<Recurso>) recursoDAO.selecionar();
    }

    public void inserirBO(Recurso recurso) throws SQLException, ClassNotFoundException {
        recursoDAO = new RecursoDAO();
        recursoDAO.inserir(recurso);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        recursoDAO = new RecursoDAO();
        recursoDAO.deletar(codigo);
    }
}
