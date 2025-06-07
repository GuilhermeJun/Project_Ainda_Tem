package br.com.fiap;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Usuario>) usuarioBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        usuarioBO.inserirBO(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(usuario.getCodigo()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {

        usuarioBO.atualizarBO(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        usuarioBO.deletarBO(codigo);
        return Response.ok().build();
    }
}
