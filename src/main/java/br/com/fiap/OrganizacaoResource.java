package br.com.fiap;

import br.com.fiap.beans.Organizacao;
import br.com.fiap.bo.OrganizacaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/organizacao")
public class OrganizacaoResource {
    private OrganizacaoBO organizacaoBO = new OrganizacaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Organizacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Organizacao>) organizacaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Organizacao organizacao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        organizacaoBO.inserirBO(organizacao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(organizacao.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        organizacaoBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
