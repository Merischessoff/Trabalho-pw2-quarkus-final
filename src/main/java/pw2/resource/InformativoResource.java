package pw2.resource;
import pw2.model.Informativo;
import pw2.model.Usuario;

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
        List<Informativo> informativos = Informativo.listAll();
        return informativos;
    }

    @POST
    @Path("{idUsuario}")
    @Transactional
    public Response create(Informativo informativo, @PathParam("idUsuario") Long idUsuario) {
        Informativo.persist(informativo);
        Usuario usu = Usuario.findById(idUsuario);
        usu.setInformativos(informativo);
        usu.persist();
        return Response.ok(informativo).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{idInformativo}")
    @Transactional
    public Response update(@PathParam("idInformativo") Long idInformativo, Informativo informativo) {
        Informativo informativoEntity = Informativo.findById(idInformativo);
        informativoEntity = informativo;
        if (informativoEntity == null) {
            throw new WebApplicationException("Informativo com o " + idInformativo + " não existe.", Response.Status.NOT_FOUND);
        }
        informativoEntity.persist();
        return Response.ok(informativoEntity).build();
    }

    @DELETE
    @Path("{idInformativo}")
    @Transactional
    public Response delete(@PathParam("idInformativo") Long idInformativo) {
        Informativo informativoEntity = Informativo.findById(idInformativo);
        if (informativoEntity == null) {
            throw new WebApplicationException("Informativo com o id " + idInformativo + " não existe.", Response.Status.NOT_FOUND);
        }
        informativoEntity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
