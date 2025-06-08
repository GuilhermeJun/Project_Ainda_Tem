package br.com.fiap.dao;

import br.com.fiap.beans.Organizacao;
import br.com.fiap.beans.TipoOrganizacao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizacaoDAO {
    public Connection minhaConexao;

    public OrganizacaoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Organizacao organizacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO ORGANIZACAO VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, organizacao.getCodigo());
        stmt.setString(2, organizacao.getNome());
        stmt.setString(3, organizacao.getEmail());
        stmt.setString(4, organizacao.getTelefone());
        stmt.setInt(5, organizacao.getTipoOrganizacao().getCodigo());
        stmt.execute();
        stmt.close();
        return "Organizacao cadastrada com sucesso";
    }

    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM ORGANIZACAO WHERE COD_ORG = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Organizacao deletada com sucesso!";
    }

    public List<Organizacao> selecionar() throws SQLException {
        List<Organizacao> organizacaoList = new ArrayList<Organizacao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT O.COD_ORG, O.NOME_ORG, O.EMAIL, O.TELEFONE, T.COD_TIPO_ORG, T.NOME_TIPO_ORG FROM ORGANIZACAO O JOIN TIPO_ORGANIZACAO T ON O.FK_TIPO_ORG = T.COD_TIPO_ORG");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Organizacao organizacao = new Organizacao();
            organizacao.setCodigo(rs.getInt(1));
            organizacao.setNome(rs.getString(2));
            organizacao.setEmail(rs.getString(3));
            organizacao.setTelefone(rs.getString(4));
            TipoOrganizacao tipoOrganizacao = new TipoOrganizacao();
            tipoOrganizacao.setCodigo(rs.getInt(5));
            tipoOrganizacao.setNome(rs.getString(6));
            organizacao.setTipoOrganizacao(tipoOrganizacao);
            organizacaoList.add(organizacao);
        }
        stmt.close();
        return organizacaoList;
    }
}
