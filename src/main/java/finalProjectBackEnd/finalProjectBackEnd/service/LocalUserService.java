package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CityDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CountryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.LocalUserDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user.LocalUserRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.UserAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class LocalUserService {

    @Autowired
    LocalUserDao localUserDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    CountryDao countryDao;


    public LocalUser registerUser(LocalUserRegistrationBodyDto localUserRegistrationBodyDto) throws UserAlreadyExistsException {

        if (localUserDao.findByUsernameIgnoreCase(localUserRegistrationBodyDto.getUsername()).isPresent() || localUserDao.findByEmailIgnoreCase(localUserRegistrationBodyDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        Country newCountry = new Country();
        City newCity = new City();
        LocalUser newUser = new LocalUser();

        newCountry.setName(localUserRegistrationBodyDto.getCityRegistrationDto().getCountryRegistrationDto().getName());
        newCountry.setCity(newCity);

        newCity.setName(localUserRegistrationBodyDto.getCityRegistrationDto().getName());
        newCity.setCountry(newCountry);

        newUser.setName(localUserRegistrationBodyDto.getName());
        newUser.setUsername(localUserRegistrationBodyDto.getUsername());
        newUser.setAddress(localUserRegistrationBodyDto.getAddress());
        newUser.setEmail(localUserRegistrationBodyDto.getEmail());
        newUser.setCity(newCity);

        countryDao.save(newCountry);
        cityDao.save(newCity);
        localUserDao.save(newUser);

        return newUser;

    }





}
