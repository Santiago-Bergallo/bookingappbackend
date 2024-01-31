package finalProjectBackEnd.finalProjectBackEnd.Dao;

import finalProjectBackEnd.finalProjectBackEnd.model.Reservation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends ListCrudRepository<Reservation, Long> {

//    List<Reservation> findByProducts_TitleIgnoreCase(String title);





}
