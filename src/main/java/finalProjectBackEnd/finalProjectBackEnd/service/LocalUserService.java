package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CityDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CountryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.LocalUserDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.LocalUserRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.UserAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.Category;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocalUserService {

    @Autowired
    LocalUserDao localUserDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    CountryDao countryDao;


    public LocalUser registerUser(LocalUserRegistrationBodyDto localUserRegistrationBodyDto) throws UserAlreadyExistsException, CityDoesNotExistException {

        if (localUserDao.findByUsernameIgnoreCase(localUserRegistrationBodyDto.getUsername()).isPresent() || localUserDao.findByEmailIgnoreCase(localUserRegistrationBodyDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        if (cityDao.findByNameIgnoreCase(localUserRegistrationBodyDto.getCityRegistrationDto().getName()).isEmpty()) {
            throw new CityDoesNotExistException();
        }

        LocalUser newUser = new LocalUser();
        Country OpCountry = countryDao.findByNameIgnoreCase(localUserRegistrationBodyDto.getCityRegistrationDto().getCountryRegistrationDto().getName()).orElse(null);
        City OpCity = cityDao.findByNameIgnoreCase(localUserRegistrationBodyDto.getCityRegistrationDto().getName()).get();

        newUser.setName(localUserRegistrationBodyDto.getName());
        newUser.setUsername(localUserRegistrationBodyDto.getUsername());
        newUser.setAddress(localUserRegistrationBodyDto.getAddress());
        newUser.setEmail(localUserRegistrationBodyDto.getEmail());
        OpCity.getLocalUsers().add(newUser);
        newUser.setCity(OpCity);

        localUserDao.save(newUser);

        return newUser;

    }

    public Optional<LocalUser> findUser(Long index) throws LocalUserDoesNotExist {
        Optional<LocalUser> found = localUserDao.findById(index);
        if (found.isEmpty()) {
            throw new LocalUserDoesNotExist();
        }
        return found;
    }
    }

