package br.com.fiap;

import br.com.fiap.beans.Solicitacao;
import br.com.fiap.bo.SolicitacaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/solicitacao")
public class SolicitacaoResource {
    private SolicitacaoBO solicitacaoBO = new SolicitacaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Solicitacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Solicitacao>) solicitacaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Solicitacao solicitacao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        solicitacaoBO.inserirBO(solicitacao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(solicitacao.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        solicitacaoBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
