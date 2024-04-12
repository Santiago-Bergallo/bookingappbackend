package finalProjectBackEnd.finalProjectBackEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Autowired
    JWTFilterRequest jwtFilterRequest;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable();

        http.authorizeHttpRequests().anyRequest().permitAll();
        return http.build();

//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors().disable();
//        http.addFilterBefore(jwtFilterRequest, AuthorizationFilter.class);
//        http.authorizeHttpRequests()
//                .requestMatchers("/products", "/users", "/login", "/me", "/register", "/verify").permitAll()
//                .anyRequest().permitAll();
//        return http.build();

    }
}
