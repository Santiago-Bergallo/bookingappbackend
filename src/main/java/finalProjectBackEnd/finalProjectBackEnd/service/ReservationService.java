package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.LocalUserDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.ProductDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.ReservationDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.reservationDto.ReservationDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import finalProjectBackEnd.finalProjectBackEnd.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

@Autowired
ReservationDao reservationDao;

@Autowired
LocalUserDao localUserDao;

@Autowired
ProductDao productDao;


public Reservation createReservation(ReservationDto reservationDto) throws LocalUserDoesNotExist, ProductDoesNotExistException {

    if (localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUser().getUsername()).isEmpty()) {
        throw new LocalUserDoesNotExist();
    }
    if (productDao.findByTitleIgnoreCase(reservationDto.getProduct().getTitle()).isEmpty()){
        throw new ProductDoesNotExistException();
    }
    LocalUser localUser = localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUser().getUsername()).get();
    Product product = productDao.findByTitleIgnoreCase(reservationDto.getProduct().getTitle()).get();

    Reservation reservation = new Reservation();

    reservation.setInitial_date(reservationDto.getInitial_date());
    reservation.setFinal_date(reservationDto.getFinal_date());
    reservation.setStage_product(reservationDto.getStage_product());
    reservation.setProduct(reservationDto.getProduct());
    reservation.setLocalUser(reservation.getLocalUser());

    localUser.getReservations().add(reservation);
    product.getReservations().add(reservation);
    localUserDao.save(localUser);
    productDao.save(product);
    reservationDao.save(reservation);


    return reservation;
};

//    public List<Reservation> findUserReservations(String username)  {
//        List<Reservation> found = reservationDao.findByLocalUsers_UsernameIgnoreCase(username);
//        for (Reservation reservation : found) {
//            found.add(reservation);
//        }
//        return found;
//    }

    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

}
