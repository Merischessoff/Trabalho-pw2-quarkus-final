package pw2.resource;

import pw2.model.Informativo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/informativos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InformativoResource {
    @GET
    public List<Informativo> listAll() {
        return Informativo.listAll();
    }

    @POST
    @Transactional
    public Response create(Informativo informativo) {
        Informativo.persist(informativo);
        return Response.ok(informativo).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Informativo informativo) {

        Informativo informativoEntity = Informativo.findById(id);

        if (informativoEntity == null) {
            throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        //informativoEntity.setUsuario(informativo.getUsuario());

        return Response.ok(informativoEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Informativo informativoEntity = Informativo.findById(id);

        if (informativoEntity == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        informativoEntity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
