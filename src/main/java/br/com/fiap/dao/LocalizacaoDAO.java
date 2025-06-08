package br.com.fiap.dao;

import br.com.fiap.beans.Localizacao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalizacaoDAO {
    public Connection minhaConexao;

    public LocalizacaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Localizacao localizacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO LOCALIZACAO VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, localizacao.getCep());
        stmt.setString(2, localizacao.getLogradouro());
        stmt.setString(3, localizacao.getBairro());
        stmt.setString(4, localizacao.getCidade());
        stmt.setString(5, localizacao.getUf());
        stmt.execute();
        stmt.close();
        return "Localizacao cadastrada com sucesso";
    }

    public String deletarReferenciaRecurso(String cep) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM RECURSO WHERE FK_LOCAL = ?");
        stmt.setString(1, cep);
        stmt.execute();
        stmt.close();
        return "Referência da localização no recurso deletado com sucesso!";
    }

    public String deletarReferenciaPontoDistribuicao(String cep) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM PONTO_DISTRIBUICAO WHERE FK_LOCAL = ?");
        stmt.setString(1, cep);
        stmt.execute();
        stmt.close();
        return "Referência da localização no ponto de distribuição deletado com sucesso!";
    }

    public String deletar(String cep) throws SQLException, ClassNotFoundException {
        LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
        localizacaoDAO.deletarReferenciaRecurso(cep);
        localizacaoDAO.deletarReferenciaPontoDistribuicao(cep);
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM LOCALIZACAO WHERE CEP = ?");
        stmt.setString(1, cep);
        stmt.execute();
        stmt.close();
        return "Localizacao deletada com sucesso!";
    }

    public List<Localizacao> selecionar() throws SQLException {
        List<Localizacao> localizacaoList = new ArrayList<Localizacao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM LOCALIZACAO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Localizacao localizacao = new Localizacao();
            localizacao.setCep(rs.getString(1));
            localizacao.setLogradouro(rs.getString(2));
            localizacao.setBairro(rs.getString(3));
            localizacao.setCidade(rs.getString(4));
            localizacao.setUf(rs.getString(5));
            localizacaoList.add(localizacao);
        }
        stmt.close();
        return localizacaoList;
    }
}
