package finalProjectBackEnd.finalProjectBackEnd.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

@Value("${jwt.algorithm.key}")
private String algorithmKey;

@Value("${jwt.issuer}")
private String issuer;

@Value("${jwt.expiry.in.seconds}")
private int expiryInSeconds;

Algorithm algorithm;

private static final String USER_KEY = "user";

@PostConstruct
    public void Postconstruct() {
    algorithm = Algorithm.HMAC256(algorithmKey);
}

public String createJwt(LocalUser localUser){
return JWT.create()
        .withClaim(USER_KEY, localUser.getUsername())
        .withIssuer(issuer)
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * expiryInSeconds))
        .sign(algorithm);
}

    public String getUserName(String token) throws JWTVerificationException {

        DecodedJWT jwt = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return jwt.getClaim(USER_KEY).asString();
    }

}
