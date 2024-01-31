package finalProjectBackEnd.finalProjectBackEnd.Dao;

import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryDao extends ListCrudRepository<Country, Long> {
    Optional<Country> findByNameIgnoreCase(String name);
}
