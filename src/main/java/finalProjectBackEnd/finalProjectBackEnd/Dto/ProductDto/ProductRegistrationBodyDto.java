package finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
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
