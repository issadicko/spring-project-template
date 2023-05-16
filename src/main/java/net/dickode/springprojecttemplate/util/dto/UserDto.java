package net.dickode.springprojecttemplate.util.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dickode.springprojecttemplate.dao.entity.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link net.dickode.springprojecttemplate.dao.entity.User} entity
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Collection<Integer> roleIds;

    public User toUser(UserDto dto){

        User user = new User();
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setId(id);

        return user;
    }

    public static UserDto fromUser(User user){
        UserDto dto = new UserDto();

        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setId(user.getId());

        return dto;
    }
}