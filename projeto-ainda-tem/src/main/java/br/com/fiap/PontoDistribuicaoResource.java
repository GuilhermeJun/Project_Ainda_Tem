package br.com.fiap;

import br.com.fiap.beans.PontoDistribuicao;
import br.com.fiap.bo.PontoDistribuicaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/pontodistribuicao")
public class PontoDistribuicaoResource {
    private PontoDistribuicaoBO pontoDistribuicaoBO = new PontoDistribuicaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PontoDistribuicao> selecionarRs() throws SQLException, ClassNotFoundException {
        return pontoDistribuicaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(PontoDistribuicao pontoDistribuicao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        pontoDistribuicaoBO.inserirBO(pontoDistribuicao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(pontoDistribuicao.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        pontoDistribuicaoBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
