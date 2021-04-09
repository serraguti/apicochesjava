package services;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Coche;
import repositories.RepositoryCoches;

@Path("/coches")
public class ServiceCoches {

    RepositoryCoches repo;

    public ServiceCoches() {
        this.repo = new RepositoryCoches();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Coche> getCoches() throws SQLException {
        return this.repo.getCoches();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Coche buscarCoche(@PathParam("id") String id) throws SQLException {
        int idcoche = Integer.parseInt(id);
        return this.repo.findCoche(idcoche);
    }
}
