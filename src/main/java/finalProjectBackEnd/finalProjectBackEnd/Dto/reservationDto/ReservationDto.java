package finalProjectBackEnd.finalProjectBackEnd.Dto.reservationDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.LocalUserRegistrationBodyDto;
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

public class ReservationDto {

    private String stage_product;

    private LocalDate initial_date;

    private LocalDate final_date;

    private ProductRegistrationBodyDto productRegistrationBodyDto;

    private LocalUserRegistrationBodyDto localUserRegistrationBodyDto;

    public String getStage_product() {
        return stage_product;
    }

    public void setStage_product(String stage_product) {
        this.stage_product = stage_product;
    }

    public LocalDate getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDate initial_date) {
        this.initial_date = initial_date;
    }

    public LocalDate getFinal_date() {
        return final_date;
    }

    public void setFinal_date(LocalDate final_date) {
        this.final_date = final_date;
    }

    public ProductRegistrationBodyDto getProductRegistrationBodyDto() {
        return productRegistrationBodyDto;
    }

    public void setProductRegistrationBodyDto(ProductRegistrationBodyDto productRegistrationBodyDto) {
        this.productRegistrationBodyDto = productRegistrationBodyDto;
    }

    public LocalUserRegistrationBodyDto getLocalUserRegistrationBodyDto() {
        return localUserRegistrationBodyDto;
    }

    public void setLocalUserRegistrationBodyDto(LocalUserRegistrationBodyDto localUserRegistrationBodyDto) {
        this.localUserRegistrationBodyDto = localUserRegistrationBodyDto;
    }
}
