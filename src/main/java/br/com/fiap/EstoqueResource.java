package br.com.fiap;

import br.com.fiap.beans.Estoque;
import br.com.fiap.bo.EstoqueBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/estoque")
public class EstoqueResource {
    private EstoqueBO estoqueBO = new EstoqueBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Estoque> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Estoque>) estoqueBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Estoque estoque, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        estoqueBO.inserirBO(estoque);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(estoque.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Estoque estoque, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        estoqueBO.atualizarBO(estoque);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        estoqueBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
