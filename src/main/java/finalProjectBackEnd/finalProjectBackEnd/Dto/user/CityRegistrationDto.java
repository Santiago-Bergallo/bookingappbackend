package finalProjectBackEnd.finalProjectBackEnd.Dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityRegistrationDto {

    private String name;

    private CountryRegistrationDto countryRegistrationDto;

    private LocalUserRegistrationBodyDto localUserRegistrationBodyDto;

}
