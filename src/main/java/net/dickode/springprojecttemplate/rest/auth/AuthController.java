package net.dickode.springprojecttemplate.rest.auth;

import lombok.RequiredArgsConstructor;
import net.dickode.springprojecttemplate.service.AuthenticationService;
import net.dickode.springprojecttemplate.util.dto.AuthenticationRequest;
import net.dickode.springprojecttemplate.util.dto.AuthenticationResponse;
import net.dickode.springprojecttemplate.util.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
