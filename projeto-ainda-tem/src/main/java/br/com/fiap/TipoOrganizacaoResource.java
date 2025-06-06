package br.com.fiap;

import br.com.fiap.beans.TipoOrganizacao;
import br.com.fiap.bo.TipoOrganizacaoBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/tipoorganizacao")
public class TipoOrganizacaoResource {
    private TipoOrganizacaoBO tipoOrganizacaoBO = new TipoOrganizacaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TipoOrganizacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<TipoOrganizacao>) tipoOrganizacaoBO.selecionarBO();
    }
}
