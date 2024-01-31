package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/create")
    public ResponseEntity createCity(@RequestBody CityRegistrationDto cityRegistrationDto) {
        try {
            cityService.createCity(cityRegistrationDto);
            return ResponseEntity.ok().build();
        } catch (CityAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/list")
    public List<City> citylist () {
        return cityService.cityList();
    }

}
