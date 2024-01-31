package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityResponseDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CountryRegistrationDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.LocalUserRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.UserAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class LocalUserController {


    @Autowired
    LocalUserService localUserService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody LocalUserRegistrationBodyDto localUserRegistrationBodyDto) throws CityDoesNotExistException {
        try {
            localUserService.registerUser(localUserRegistrationBodyDto);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/find/{id}")
    public Optional<LocalUser> findUser(@PathVariable Long id) throws LocalUserDoesNotExist {

            Optional<LocalUser> user = localUserService.findUser(id);
            if (user.isPresent()){
                LocalUser userFound = user.get();
                City city = new City();
                List<LocalUser> localUserList = userFound.getCity().getLocalUsers();
                List<LocalUser> foundLocalUserList = new ArrayList<>();
                for (LocalUser localUser : localUserList) {
                    if (localUser.getId() == user.get().getId()) {
                        foundLocalUserList.add(localUser);
                        System.out.println(localUser.getCity().toString()+"\n");
                    }
                }

                city.setCountry(userFound.getCity().getCountry());
                city.setName(userFound.getName());
                city.setLocalUsers(foundLocalUserList);
                return Optional.of(userFound);
            }


        return null;
    }


}
