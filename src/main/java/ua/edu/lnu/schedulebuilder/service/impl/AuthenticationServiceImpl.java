package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.edu.lnu.schedulebuilder.dto.AuthenticationRequestDTO;
import ua.edu.lnu.schedulebuilder.dto.AuthenticationResponseDTO;
import ua.edu.lnu.schedulebuilder.dto.RegistrationRequestDTO;
import ua.edu.lnu.schedulebuilder.dto.UserDTO;
import ua.edu.lnu.schedulebuilder.mapper.UserMapper;
import ua.edu.lnu.schedulebuilder.model.Role;
import ua.edu.lnu.schedulebuilder.repository.UserRepository;
import ua.edu.lnu.schedulebuilder.service.AuthenticationService;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    public final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponseDTO register(RegistrationRequestDTO request) {
        UserDTO userDTO =
            new UserDTO(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                Role.USER);
        userRepository.save(userMapper.dtoToEntity(userDTO));
        var jwtToken =
            jwtService.generateToken(userMapper.dtoToEntity(userDTO));
        return AuthenticationResponseDTO.builder()
            .jwt(jwtToken)
            .build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(
        AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken =
            jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
            .jwt(jwtToken)
            .build();
    }
}
