package pw2.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import pw2.model.Empresa;

public class EmpresaResource {
    @GET
    public List<Empresa> listAll() {
        return Empresa.listAll();
    }

    @POST
    @Transactional
    public Response create(Empresa empresa) {
        Empresa.persist(empresa);
        return Response.ok(empresa).status(Response.Status.CREATED).build();
    }

    // @PUT
    // @Path("{id}")
    // @Transactional
    // public Response update(@PathParam("id") Long id, Informativo informativo) {

    //     Informativo informativoEntity = Informativo.findById(id);

    //     if (informativoEntity == null) {
    //         throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
    //     }

    //     //informativoEntity.setUsuario(informativo.getUsuario());

    //     return Response.ok(informativoEntity).build();
    // }

    // @DELETE
    // @Path("{id}")
    // @Transactional
    // public Response delete(@PathParam("id") Long id) {
    //     Informativo informativoEntity = Informativo.findById(id);

    //     if (informativoEntity == null) {
    //         throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
    //     }

    //     informativoEntity.delete();
    //     return Response.status(Response.Status.NO_CONTENT).build();
    // }
}
