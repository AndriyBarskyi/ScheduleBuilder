package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.AuthenticationRequestDTO;
import ua.edu.lnu.schedulebuilder.dto.AuthenticationResponseDTO;
import ua.edu.lnu.schedulebuilder.dto.RegistrationRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegistrationRequestDTO request);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
