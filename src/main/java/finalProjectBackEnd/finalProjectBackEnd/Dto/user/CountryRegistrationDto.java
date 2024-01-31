package finalProjectBackEnd.finalProjectBackEnd.Dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CountryRegistrationDto {



    private String name;

    private List<CityRegistrationDto> cityRegistrationDtos;

}
