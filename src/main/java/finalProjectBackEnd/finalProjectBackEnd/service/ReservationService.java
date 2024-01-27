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

@Service
public class ReservationService {

@Autowired
    ReservationDao reservationDao;

@Autowired
    LocalUserDao localUserDao;

@Autowired
    ProductDao productDao;


public Reservation createReservation(ReservationDto reservationDto) throws LocalUserDoesNotExist, ProductDoesNotExistException {

    if (localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUsers().get(0).getUsername()).isEmpty()) {
        throw new LocalUserDoesNotExist();
    }
    if (productDao.findByTitleIgnoreCase(reservationDto.getProducts().get(0).getTitle()).isEmpty()){
        throw new ProductDoesNotExistException();
    }
    LocalUser localUser = localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUsers().get(0).getUsername()).get();
    Product product = productDao.findByTitleIgnoreCase(reservationDto.getProducts().get(0).getTitle()).get();

    Reservation reservation = new Reservation();

    reservation.setInitial_date(reservationDto.getInitial_date());
    reservation.setFinal_date(reservationDto.getFinal_date());
    reservation.setStage_product(reservationDto.getStage_product());
    reservation.setProducts(reservation.getProducts());
    reservation.getProducts().add(product);
    reservation.setLocalUsers(reservation.getLocalUsers());
    reservation.getLocalUsers().add(localUser);
    reservationDao.save(reservation);
    return reservation;
};


}
