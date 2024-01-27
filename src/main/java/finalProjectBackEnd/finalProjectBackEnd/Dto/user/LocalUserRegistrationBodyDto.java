package finalProjectBackEnd.finalProjectBackEnd.Dto.user;

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
