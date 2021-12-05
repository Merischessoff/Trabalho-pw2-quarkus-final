package pw2.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import pw2.model.Informativo;

@ApplicationScoped
public class InformativoRepository implements PanacheRepository<Informativo>{
     
    public List<Informativo> listAll() {
        return listAll();
    }

    @Transactional
    public Informativo save(Informativo informativo) {
        persist(informativo);
        return informativo;
    }

    @Transactional
    public Informativo update(Long id, Informativo car) {
        Informativo informativoEntity = findById(id);

        if (informativoEntity == null) {
            throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        //carEntity.setName(car.getName());
        //carEntity.setBrand(car.getBrand());
        //note that once persisted, you don't need to explicitly save your entity: all
        //modifications are automatically persisted on transaction commit.
        //persist(carEntity);//opcional 
        return informativoEntity;
    }

    @Transactional
    public void remove(Long id) {
        Informativo informativoEntity = findById(id);

        if (informativoEntity == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        delete(informativoEntity);
    }

}
