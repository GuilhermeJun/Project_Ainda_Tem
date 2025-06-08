package br.com.fiap.dao;

import br.com.fiap.beans.Estoque;
import br.com.fiap.beans.Recurso;
import br.com.fiap.beans.Solicitacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDAO {
    public Connection minhaConexao;

    public SolicitacaoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Solicitacao solicitacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO SOLICITACAO VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, solicitacao.getId());
        stmt.setInt(2, solicitacao.getQuantidade());
        stmt.setTimestamp(3, solicitacao.getDataSolicitacao());
        stmt.setString(4, solicitacao.getStatus());
        stmt.setInt(5, solicitacao.getUsuario().getCodigo());
        stmt.setInt(6, solicitacao.getEstoque().getCodigo());
        stmt.setInt(7, solicitacao.getRecurso().getCodigo());
        stmt.execute();
        stmt.close();
        return "Solicitacao inserida com sucesso";
    }

    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM SOLICITACAO WHERE COD_SOLIC = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        return "Solicitacao deletada com sucesso!";
    }

    public List<Solicitacao> selecionar() throws SQLException {
        List<Solicitacao> solicitacaoList = new ArrayList<Solicitacao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT S.ID_SOLIC, S.QUANTIDADE, S.DATA_SOLIC, S.STATUS, U.COD_USU, U.NOME_USU, E.COD_EST, E.NOME_EST, E.QUANTIDADE, R.COD_REC, R.QUANT_DISP, R.STATUS FROM SOLICITACAO S JOIN USUARIO U ON S.FK_USU = U.COD_USU JOIN ESTOQUE E ON S.FK_EST = E.COD_EST JOIN RECURSO R ON S.FK_REC = R.COD_REC");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setId(rs.getInt(1));
            solicitacao.setQuantidade(rs.getInt(2));
            solicitacao.setDataSolicitacao(rs.getTimestamp(3));
            solicitacao.setStatus(rs.getString(4));

            Usuario usuario = new Usuario();
            usuario.setCodigo(rs.getInt(5));
            usuario.setNome(rs.getString(6));

            Estoque estoque = new Estoque();
            estoque.setCodigo(rs.getInt(7));
            estoque.setNome(rs.getString(8));
            estoque.setQuantidade(rs.getInt(9));

            Recurso recurso = new Recurso();
            recurso.setCodigo(rs.getInt(10));
            recurso.setQuantDisponivel(rs.getInt(11));
            recurso.setStatus(rs.getString(12));


            solicitacao.setUsuario(usuario);
            solicitacao.setEstoque(estoque);
            solicitacao.setRecurso(recurso);
            solicitacaoList.add(solicitacao);
        }
        stmt.close();
        return solicitacaoList;
    }
}
