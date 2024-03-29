package finalProjectBackEnd.finalProjectBackEnd.Dao;

import finalProjectBackEnd.finalProjectBackEnd.model.City;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityDao extends ListCrudRepository<City, Long> {
    Optional<City> findByNameIgnoreCase(String name);



}


