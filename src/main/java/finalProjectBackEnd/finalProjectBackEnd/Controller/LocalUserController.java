package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.user.LocalUserRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.UserAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
