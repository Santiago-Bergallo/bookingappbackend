package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.reservationDto.ReservationDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.model.Reservation;
import finalProjectBackEnd.finalProjectBackEnd.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity createReservation(@RequestBody ReservationDto reservationDto) {
        try {
            Reservation newReservation = reservationService.createReservation(reservationDto);
            return ResponseEntity.ok(newReservation);
        } catch (LocalUserDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (ProductDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
