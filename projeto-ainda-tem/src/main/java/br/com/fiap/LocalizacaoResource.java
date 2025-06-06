package br.com.fiap;

import br.com.fiap.beans.Localizacao;
import br.com.fiap.bo.LocalizacaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/localizacao")
public class LocalizacaoResource {
    private LocalizacaoBO localizacaoBO = new LocalizacaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Localizacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return localizacaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Localizacao localizacao) throws SQLException, ClassNotFoundException {
        localizacaoBO.inserirBO(localizacao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("cep") String cep) throws SQLException, ClassNotFoundException {
        localizacaoBO.deletarBO(cep);
        return Response.ok().build();
    }
}
