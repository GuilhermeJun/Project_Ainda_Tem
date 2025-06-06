package br.com.fiap.dao;

import br.com.fiap.beans.TipoOrganizacao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoOrganizacaoDAO {
    public Connection minhaConexao;

    public TipoOrganizacaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public List<TipoOrganizacao> selecionar() throws SQLException {
        List<TipoOrganizacao> tipoOrganizacaoList = new ArrayList<TipoOrganizacao>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM TIPO_ORGANIZACAO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TipoOrganizacao tipoOrganizacao = new TipoOrganizacao();
            tipoOrganizacao.setCodigo(rs.getInt(1));
            tipoOrganizacao.setNome(rs.getString(2));
            tipoOrganizacaoList.add(tipoOrganizacao);
        }
        stmt.close();
        return tipoOrganizacaoList;
    }
}
