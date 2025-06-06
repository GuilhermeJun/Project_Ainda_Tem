package br.com.fiap.bo;

import br.com.fiap.beans.Localizacao;
import br.com.fiap.dao.LocalizacaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalizacaoBO {
    LocalizacaoDAO localizacaoDAO;

    public ArrayList<Localizacao> selecionarBO() throws SQLException, ClassNotFoundException {
        localizacaoDAO = new LocalizacaoDAO();
        return (ArrayList<Localizacao>) localizacaoDAO.selecionar();
    }

    public String inserirBO(Localizacao localizacao) throws SQLException, ClassNotFoundException {
        localizacaoDAO = new LocalizacaoDAO();
        return localizacaoDAO.inserir(localizacao);
    }

    public String deletarBO(String cep) throws SQLException, ClassNotFoundException {
        localizacaoDAO = new LocalizacaoDAO();
        return localizacaoDAO.deletar(cep);
    }
}
