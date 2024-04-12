package finalProjectBackEnd.finalProjectBackEnd.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

@Value("${encryption.salt.rounds}")
private int saltRounds;

String salt;

@PostConstruct
public void postConstruct() { salt = BCrypt.gensalt(saltRounds);}

public String encryptPassword(String password) {
    return BCrypt.hashpw(password, salt);
}

public Boolean checkPassword(String hash, String password){
    return BCrypt.checkpw(hash, password);
}



}
