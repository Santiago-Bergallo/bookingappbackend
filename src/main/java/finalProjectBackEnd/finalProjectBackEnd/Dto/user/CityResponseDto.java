package finalProjectBackEnd.finalProjectBackEnd.Dto.user;

import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CityResponseDto {

    private String name;

    private Country country;

    private List<LocalUser> localUserList;



}
