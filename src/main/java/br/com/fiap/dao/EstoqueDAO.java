package br.com.fiap.dao;

import br.com.fiap.SolicitacaoResource;
import br.com.fiap.beans.Categoria;
import br.com.fiap.beans.Estoque;
import br.com.fiap.beans.Item;
import br.com.fiap.beans.PontoDistribuicao;
import br.com.fiap.bo.EstoqueBO;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public Connection minhaConexao;

    public EstoqueDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Estoque estoque) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO ESTOQUE VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, estoque.getCodigo());
        stmt.setString(2, estoque.getNome());
        stmt.setInt(3, estoque.getQuantidade());
        stmt.setTimestamp(4, estoque.getUltimaAtualizacao());
        stmt.setInt(5, estoque.getItem().getCodigo());
        stmt.setInt(6, estoque.getPontoDistribuicao().getCodigo());
        stmt.execute();
        stmt.close();
        return "Estoque cadastrado com sucesso";
    }

    public String atualizar(Estoque estoque) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE ESTOQUE SET NOME_EST = ?, QUANTIDADE = ?, ULTIMA_ATUA = ?, FK_ITEM = ?, FK_PONTO = ? WHERE COD_EST = ?");
        stmt.setString(1, estoque.getNome());
        stmt.setInt(2, estoque.getQuantidade());
        stmt.setTimestamp(3, estoque.getUltimaAtualizacao());
        stmt.setInt(4, estoque.getItem().getCodigo());
        stmt.setInt(5, estoque.getPontoDistribuicao().getCodigo());
        stmt.setInt(6, estoque.getCodigo());
        stmt.executeUpdate();
        stmt.close();
        return "Estoque atualizado com sucesso";
    }

    public String deletarReferenciaSolicitacao(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM SOLICITACAO WHERE FK_EST = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Referência do estoque na solicitação deletado com sucesso!";
    }

    public String deletar(int codigo) throws SQLException, ClassNotFoundException {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        estoqueDAO.deletarReferenciaSolicitacao(codigo);
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM ESTOQUE WHERE COD_EST = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Estoque deletado com sucesso!";
    }

    public List<Estoque> selecionar() throws SQLException {
        List<Estoque> estoqueList = new ArrayList<Estoque>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT E.COD_EST, E.NOME_EST, E.QUANTIDADE, E.ULTIMA_ATUA, I.COD_ITEM, I.NOME_ITEM, I.INFO_ADICIONAL, I.DATA_VALIDADE, C.COD_CATEG, C.NOME_CATEG, P.COD_PONTO, P.NOME_PONTO, P.OBSERVACAO FROM ESTOQUE E JOIN ITEM I ON E.FK_ITEM = I.COD_ITEM JOIN CATEGORIA C ON I.FK_CATEG = C.COD_CATEG JOIN PONTO_DISTRIBUICAO P ON E.FK_PONTO = P.COD_PONTO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estoque estoque = new Estoque();
            estoque.setCodigo(rs.getInt(1));
            estoque.setNome(rs.getString(2));
            estoque.setQuantidade(rs.getInt(3));
            estoque.setUltimaAtualizacao(rs.getTimestamp(4));

            Item item = new Item();
            item.setCodigo(rs.getInt(5));
            item.setNome(rs.getString(6));
            item.setInformacaoAdicional(rs.getString(7));
            item.setDataValidade(rs.getTimestamp(8));

            Categoria categoria = new Categoria();
            categoria.setCodigo(rs.getInt(9));
            categoria.setNome(rs.getString(10));

            PontoDistribuicao pontoDistribuicao = new PontoDistribuicao();
            pontoDistribuicao.setCodigo(rs.getInt(11));
            pontoDistribuicao.setNome(rs.getString(12));
            pontoDistribuicao.setObservacao(rs.getString(13));

            item.setCategoria(categoria);
            estoque.setItem(item);
            estoque.setPontoDistribuicao(pontoDistribuicao);

            estoqueList.add(estoque);
        }
        stmt.close();
        return estoqueList;
    }
}
