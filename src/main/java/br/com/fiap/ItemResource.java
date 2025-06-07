package br.com.fiap;

import br.com.fiap.beans.Item;
import br.com.fiap.bo.ItemBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/item")
public class ItemResource {
    private ItemBO itemBO = new ItemBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Item> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Item>) itemBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Item item, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        itemBO.inserirBO(item);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(item.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        itemBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
