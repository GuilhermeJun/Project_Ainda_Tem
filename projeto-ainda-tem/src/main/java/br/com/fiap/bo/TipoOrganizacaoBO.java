package br.com.fiap.bo;

import br.com.fiap.beans.TipoOrganizacao;
import br.com.fiap.dao.TipoOrganizacaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoOrganizacaoBO {
    TipoOrganizacaoDAO tipoOrganizacaoDAO;

    public ArrayList<TipoOrganizacao> selecionarBO() throws SQLException, ClassNotFoundException {
        tipoOrganizacaoDAO = new TipoOrganizacaoDAO();

        return (ArrayList<TipoOrganizacao>) tipoOrganizacaoDAO.selecionar();
    }
}
