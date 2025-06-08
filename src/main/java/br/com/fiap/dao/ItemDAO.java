package br.com.fiap.dao;

import br.com.fiap.beans.Categoria;
import br.com.fiap.beans.Item;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public Connection minhaConexao;

    public ItemDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir (Item item) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO ITEM VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, item.getCodigo());
        stmt.setString(2, item.getNome());
        stmt.setString(3, item.getInformacaoAdicional());
        stmt.setTimestamp(4, item.getDataValidade());
        stmt.setInt(5, item.getCategoria().getCodigo());
        stmt.execute();
        stmt.close();
        return "Item cadastrado com sucesso";
    }

    public String deletar (int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM ITEM WHERE COD_ITEM = ?");

        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Item deletado com sucesso!";
    }

    public List<Item> selecionar () throws SQLException {
        List<Item> itemList = new ArrayList<Item>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT I.COD_ITEM, I.NOME_ITEM, I.INFO_ADICIONAL, I.DATA_VALIDADE, C.COD_CATEG, C.NOME_CATEG FROM ITEM I JOIN CATEGORIA C ON I.FK_CATEG=C.COD_CATEG");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Item item = new Item();
            item.setCodigo(rs.getInt(1));
            item.setNome(rs.getString(2));
            item.setInformacaoAdicional(rs.getString(3));
            item.setDataValidade(rs.getTimestamp(4));
            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt(5));
            categoria.setNome(rs.getString(6));
            item.setCategoria(categoria);
            itemList.add(item);
        }
        stmt.close();
        return itemList;
    }
}
