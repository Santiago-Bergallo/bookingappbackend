package finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user;

import finalProjectBackEnd.finalProjectBackEnd.model.City;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocalUserRegistrationBodyDto {

    private String name;

    private String username;

    private String email;

    private String address;

    private CityRegistrationDto cityRegistrationDto;
}
