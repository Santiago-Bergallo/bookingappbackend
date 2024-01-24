package finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user;

import finalProjectBackEnd.finalProjectBackEnd.model.City;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CountryRegistrationDto {



    private String name;

    private CityRegistrationDto cityRegistrationDto;

}
