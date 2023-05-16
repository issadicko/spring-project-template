package net.dickode.springprojecttemplate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dickode.springprojecttemplate.dao.entity.User;
import net.dickode.springprojecttemplate.dao.repository.UserRepository;
import net.dickode.springprojecttemplate.util.config.JwtService;
import net.dickode.springprojecttemplate.util.dto.AuthenticationRequest;
import net.dickode.springprojecttemplate.util.dto.AuthenticationResponse;
import net.dickode.springprojecttemplate.util.dto.RegisterRequest;
import net.dickode.springprojecttemplate.util.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        log.info("Authenticating user : "+request.getEmail());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );


            log.info("Generation user token ...");
            var userOptional = userRepository.findByEmail(request.getEmail());

            if (userOptional.isEmpty()) {
                log.info("User not found in the DB !");
                throw new  Exception();
            }

            User user = userOptional.get();

            var jwt = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwt)
                    .user(UserDto.fromUser(user))
                    .build();
        }catch (Exception e){

            e.printStackTrace();
            throw  new  BadCredentialsException(e.getMessage());

        }

    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of())
                .build();

        userRepository.save(user);

        var jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
