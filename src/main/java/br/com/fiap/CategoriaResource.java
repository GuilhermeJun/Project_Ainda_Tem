package br.com.fiap;

import br.com.fiap.beans.Categoria;
import br.com.fiap.bo.CategoriaBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/categoria")
public class CategoriaResource {
    private CategoriaBO categoriaBO = new CategoriaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Categoria> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Categoria>) categoriaBO.selecionarBO();
    }
}
