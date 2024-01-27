package finalProjectBackEnd.finalProjectBackEnd.Dto.reservationDto;

import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ReservationDto {

    private String stage_product;

    private LocalDate initial_date;

    private LocalDate final_date;

    private List<Product> products = new ArrayList<>();

    private List<LocalUser> localUsers = new ArrayList<>();

}
