package net.dickode.springprojecttemplate.util.dto;

import lombok.Builder;
import lombok.Data;
import net.dickode.springprojecttemplate.dao.entity.User;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private UserDto user;
}
