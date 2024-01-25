package finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user.CityRegistrationDto;
import finalProjectBackEnd.finalProjectBackEnd.model.Category;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRegistrationBodyDto {

    private String title;

    private String address;

    private String shortDescription;

    private CategoryRegistrationBody categoryRegistrationBody;

    private CityRegistrationDto cityRegistrationDto;

}
