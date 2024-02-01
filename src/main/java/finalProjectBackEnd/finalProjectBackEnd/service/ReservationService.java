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

    if (localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUserRegistrationBodyDto().getUsername()).isPresent() && productDao.findByTitleIgnoreCase(reservationDto.getProductRegistrationBodyDto().getTitle()).isPresent()) {
        LocalUser localUser = localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUserRegistrationBodyDto().getUsername()).get();
        Product product = productDao.findByTitleIgnoreCase(reservationDto.getProductRegistrationBodyDto().getTitle()).get();

        Reservation reservation = new Reservation();

        reservation.setInitial_date(reservationDto.getInitial_date());
        reservation.setFinal_date(reservationDto.getFinal_date());
        reservation.setStage_product(reservationDto.getStage_product());
        reservation.setProduct(product);
        reservation.setLocalUser(localUser);

        localUser.getReservations().add(reservation);
        product.getReservations().add(reservation);
        localUserDao.save(localUser);
        productDao.save(product);
        reservationDao.save(reservation);


        return reservation;
    }
    else {
        if (localUserDao.findByUsernameIgnoreCase(reservationDto.getLocalUserRegistrationBodyDto().getUsername()).isEmpty()) {
            throw new LocalUserDoesNotExist();
        }
        else throw new ProductDoesNotExistException();
    }
}
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

}
