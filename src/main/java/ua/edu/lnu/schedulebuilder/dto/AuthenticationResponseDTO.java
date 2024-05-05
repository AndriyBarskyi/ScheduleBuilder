package ua.edu.lnu.schedulebuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class AuthenticationResponseDTO {
    private String token;
    private Boolean isAuth;
}