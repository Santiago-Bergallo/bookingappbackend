package finalProjectBackEnd.finalProjectBackEnd.Dto.reservationDto;

import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ReservationDto {

    private String stage_product;

    private LocalDate initial_date;

    private LocalDate final_date;

    private Product product;

    private LocalUser localUser;

}
