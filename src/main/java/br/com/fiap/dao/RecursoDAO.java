package br.com.fiap.dao;

import br.com.fiap.beans.Item;
import br.com.fiap.beans.Localizacao;
import br.com.fiap.beans.Recurso;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {
    public Connection minhaConexao;

    public RecursoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Recurso recurso) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO RECURSO VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, recurso.getCodigo());
        stmt.setTimestamp(2, recurso.getDataCadastro());
        stmt.setInt(3, recurso.getQuantDisponivel());
        stmt.setString(4, recurso.getStatus());
        stmt.setInt(5, recurso.getUsuario().getCodigo());
        stmt.setInt(6, recurso.getItem().getCodigo());
        stmt.setString(7, recurso.getLocalizacao().getCep());
        stmt.execute();
        stmt.close();
        return "Recurso cadastrado com sucesso";
    }

    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM RECURSO WHERE COD_REC = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Recurso deletado com sucesso!";
    }

    public List<Recurso> selecionar() throws SQLException {
        List<Recurso> recursoList = new ArrayList<Recurso>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT R.COD_REC, R.DATA_CADASTRO, R.QUANT_DISP, R.STATUS, U.COD_USU, U.NOME_USU, I.COD_ITEM, I.NOME_ITEM, L.CEP FROM RECURSO R JOIN USUARIO U ON R.FK_USU = U.COD_USU JOIN ITEM I ON R.FK_ITEM = I.COD_ITEM JOIN LOCALIZACAO L ON R.FK_LOCAL = L.CEP");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Recurso recurso = new Recurso();
            recurso.setCodigo(rs.getInt(1));
            recurso.setDataCadastro(rs.getTimestamp(2));
            recurso.setQuantDisponivel(rs.getInt(3));
            recurso.setStatus(rs.getString(4));
            Usuario usuario = new Usuario();
            usuario.setCodigo(rs.getInt(5));
            usuario.setNome(rs.getString(6));
            Item item = new Item();
            item.setCodigo(rs.getInt(7));
            item.setNome(rs.getString(8));
            Localizacao localizacao = new Localizacao();
            localizacao.setCep(rs.getString(9));
            recurso.setUsuario(usuario);
            recurso.setItem(item);
            recurso.setLocalizacao(localizacao);
            recursoList.add(recurso);
        }
        stmt.close();
        return recursoList;
    }
}
