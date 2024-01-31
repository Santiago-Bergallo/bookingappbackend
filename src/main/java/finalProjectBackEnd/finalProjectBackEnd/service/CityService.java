package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CityDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CountryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.model.Country;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityDao cityDao;

    @Autowired
    CountryDao countryDao;

    public City createCity(CityRegistrationDto cityRegistrationDto) throws CityAlreadyExistsException {
        if (cityDao.findByNameIgnoreCase(cityRegistrationDto.getName()).isPresent()) {
            throw new CityAlreadyExistsException();
        }

        City newCity = new City();
        Country newCountry = new Country();
        Country found = null;

        Optional<Country> opCountry = countryDao.findByNameIgnoreCase(cityRegistrationDto.getCountryRegistrationDto().getName());
        if (opCountry.isPresent()) {
            found = opCountry.get();
            found.getCities().add(newCity);
            newCity.setCountry(found);
        }
        else {
            newCountry.setName(cityRegistrationDto.getCountryRegistrationDto().getName());
            newCountry.getCities().add(newCity);
            newCity.setCountry(newCountry);
            countryDao.save(newCountry);
        }

        newCity.setName(cityRegistrationDto.getName());

        cityDao.save(newCity);
        return newCity;
    }

    public List<City> cityList () {
       return cityDao.findAll();
    }

}
