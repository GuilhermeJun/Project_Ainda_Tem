package br.com.fiap;

import br.com.fiap.beans.Recurso;
import br.com.fiap.bo.RecursoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/recurso")
public class RecursoResource {
    private RecursoBO recursoBO = new RecursoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recurso> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Recurso>) recursoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Recurso recurso, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        recursoBO.inserirBO(recurso);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(recurso.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        recursoBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
