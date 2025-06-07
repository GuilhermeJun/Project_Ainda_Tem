package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBO {
    UsuarioDAO usuarioDAO;

    public ArrayList<Usuario> selecionarBO() throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
        return (ArrayList<Usuario>) usuarioDAO.selecionar();
    }

    public void inserirBO(Usuario usuario) throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }

    public void atualizarBO(Usuario usuario) throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizar(usuario);
    }

    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.deletar(codigo);
    }
}
