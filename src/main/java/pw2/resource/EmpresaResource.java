package pw2.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import pw2.model.Empresa;

@Path("/empresas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaResource {
    @POST
    @Transactional
    public Response create(Empresa empresa) {
        Empresa.persist(empresa);
        return Response.ok(empresa).status(Response.Status.CREATED).build();
    }

    
}
