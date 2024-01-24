package finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user;

import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityRegistrationDto {

    private String name;

    private CountryRegistrationDto countryRegistrationDto;

    private LocalUserRegistrationBodyDto localUserRegistrationBodyDto;

}
