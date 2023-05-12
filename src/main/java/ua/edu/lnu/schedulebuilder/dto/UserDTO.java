package ua.edu.lnu.schedulebuilder.dto;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.edu.lnu.schedulebuilder.model.Role;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String password;
    private Boolean isActive;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public UserDTO(String firstName,
        String lastName,
        String email,
        String password,
        Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}