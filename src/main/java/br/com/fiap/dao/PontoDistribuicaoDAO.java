package br.com.fiap.dao;

import br.com.fiap.beans.Localizacao;
import br.com.fiap.beans.Organizacao;
import br.com.fiap.beans.PontoDistribuicao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PontoDistribuicaoDAO {
    public Connection minhaConexao;

    public PontoDistribuicaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(PontoDistribuicao pontoDistribuicao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO PONTO_DISTRIBUICAO VALUES (?, ?, ?, ?, ?)");
        stmt.setInt(1, pontoDistribuicao.getCodigo());
        stmt.setString(2, pontoDistribuicao.getNome());
        stmt.setString(3, pontoDistribuicao.getObservacao());
        stmt.setInt(4, pontoDistribuicao.getOrganizacao().getCodigo());
        stmt.setString(5, pontoDistribuicao.getLocalizacao().getCep());
        stmt.execute();
        stmt.close();
        return "Ponto distribuicao cadastrado com sucesso";
    }
    
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM PONTO_DISTRIBUICAO WHERE COD_PONTO = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Ponto distribuicao deletado com sucesso!";
    }
    
    public List<PontoDistribuicao> selecionar() throws SQLException {
        List<PontoDistribuicao> pontoDistribuicaoList = new ArrayList<PontoDistribuicao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT P.COD_PONTO, P.NOME_PONTO, P.OBSERVACAO, O.COD_ORG, O.NOME_ORG, O.EMAIL, O.TELEFONE, L.CEP, L.LOGRADOURO, L.BAIRRO, L.CIDADE, L.UF FROM PONTO_DISTRIBUICAO P JOIN ORGANIZACAO O ON P.FK_ORG = O.COD_ORG JOIN LOCALIZACAO L ON P.FK_LOCAL = L.CEP");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            PontoDistribuicao pontoDistribuicao = new PontoDistribuicao();
            pontoDistribuicao.setCodigo(rs.getInt(1));
            pontoDistribuicao.setNome(rs.getString(2));
            pontoDistribuicao.setObservacao(rs.getString(3));

            Organizacao organizacao = new Organizacao();
            organizacao.setCodigo(rs.getInt(4));
            organizacao.setNome(rs.getString(5));
            organizacao.setEmail(rs.getString(6));
            organizacao.setTelefone(rs.getString(7));
            pontoDistribuicao.setOrganizacao(organizacao);

            Localizacao localizacao = new Localizacao();
            localizacao.setCep(rs.getString(8));
            localizacao.setLogradouro(rs.getString(9));
            localizacao.setBairro(rs.getString(10));
            localizacao.setCidade(rs.getString(11));
            localizacao.setUf(rs.getString(12));
            pontoDistribuicao.setLocalizacao(localizacao);

            pontoDistribuicaoList.add(pontoDistribuicao);
        }
        rs.close();
        stmt.close();
        return pontoDistribuicaoList;
    }
}
