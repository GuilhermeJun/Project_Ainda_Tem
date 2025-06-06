package br.com.fiap.dao;

import br.com.fiap.beans.Categoria;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public Connection minhaConexao;

    public CategoriaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public List<Categoria> selecionar() throws SQLException {
        List<Categoria> categoriaList = new ArrayList<Categoria>();

        PreparedStatement stmt = minhaConexao.prepareStatement("select * from categoria");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt(1));
            categoria.setNome(rs.getString(2));
            categoriaList.add(categoria);
        }
        stmt.close();
        return categoriaList;
    }
}
