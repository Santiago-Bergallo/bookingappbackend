package finalProjectBackEnd.finalProjectBackEnd.Dao;

import finalProjectBackEnd.finalProjectBackEnd.model.City;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends ListCrudRepository<City, Long> {
}
