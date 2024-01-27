package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.user.LocalUserRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.UserAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class LocalUserController {


    @Autowired
    LocalUserService localUserService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody LocalUserRegistrationBodyDto localUserRegistrationBodyDto) {
        try {
            localUserService.registerUser(localUserRegistrationBodyDto);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/find/{id}")
    public Optional<LocalUser> findUser(@PathVariable Long id) {
        try {
            return localUserService.findUser(id);
        } catch (LocalUserDoesNotExist e) {
            throw new RuntimeException(e);
        }
    }


}
