package br.com.fiap.dao;

import br.com.fiap.beans.Organizacao;
import br.com.fiap.beans.TipoOrganizacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO USUARIO VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, usuario.getCodigo());
        stmt.setString(2, usuario.getNome());
        stmt.setInt(3, usuario.getIdade());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getSenha());
        stmt.setString(7, usuario.getTipoUsuario());
        stmt.setInt(8, usuario.getOrganizacao().getCodigo());
        stmt.execute();
        stmt.close();
        return "Usuario cadastrado com sucesso";
    }

    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE USUARIO SET NOME_USU = ?, IDADE = ?, TELEFONE = ?, EMAIL = ?, SENHA = ?, TIPO_USU = ? WHERE COD_USU = ?");
        stmt.setString(1, usuario.getNome());
        stmt.setInt(2, usuario.getIdade());
        stmt.setString(3, usuario.getTelefone());
        stmt.setString(4, usuario.getEmail());
        stmt.setString(5, usuario.getSenha());
        stmt.setString(6, usuario.getTipoUsuario());
        stmt.setInt(7, usuario.getCodigo());
        stmt.executeUpdate();
        stmt.close();
        return "Usuario atualizado com sucesso";
    }

    public String deletarReferenciaSolicitacao(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM SOLICITACAO WHERE FK_USU = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Referência do usuário na solicitação deletado com sucesso!";
    }

    public String deletarReferenciaRecurso(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM RECURSO WHERE FK_USU = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Referência do usuário no recurso deletado com sucesso!";
    }

    public String deletar(int codigo) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deletarReferenciaSolicitacao(codigo);
        usuarioDAO.deletarReferenciaRecurso(codigo);
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM USUARIO WHERE COD_USU = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Usuario deletado com sucesso!";
    }

    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT U.COD_USU, U.NOME_USU, U.IDADE, U.TELEFONE, U.EMAIL, U.TIPO_USU, O.COD_ORG, O.NOME_ORG, O.EMAIL, O.TELEFONE, T.COD_TIPO_ORG, T.NOME_TIPO_ORG FROM USUARIO U JOIN ORGANIZACAO O ON U.FK_ORG = O.COD_ORG JOIN TIPO_ORGANIZACAO T ON O.FK_TIPO_ORG = T.COD_TIPO_ORG");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCodigo(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setIdade(rs.getInt(3));
            usuario.setTelefone(rs.getString(4));
            usuario.setEmail(rs.getString(5));
            usuario.setTipoUsuario(rs.getString(6));

            Organizacao organizacao = new Organizacao();
            organizacao.setCodigo(rs.getInt(7));
            organizacao.setNome(rs.getString(8));
            organizacao.setEmail(rs.getString(9));
            organizacao.setTelefone(rs.getString(10));

            TipoOrganizacao tipoOrganizacao = new TipoOrganizacao();
            tipoOrganizacao.setCodigo(rs.getInt(11));
            tipoOrganizacao.setNome(rs.getString(12));
            organizacao.setTipoOrganizacao(tipoOrganizacao);
            usuario.setOrganizacao(organizacao);
            usuarioList.add(usuario);
        }
        stmt.close();
        return usuarioList;
    }
}
