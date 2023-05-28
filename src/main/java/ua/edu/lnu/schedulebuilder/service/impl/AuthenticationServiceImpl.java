package ua.edu.lnu.schedulebuilder.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.edu.lnu.schedulebuilder.dto.AuthenticationRequestDTO;
import ua.edu.lnu.schedulebuilder.dto.AuthenticationResponseDTO;
import ua.edu.lnu.schedulebuilder.dto.RegistrationRequestDTO;
import ua.edu.lnu.schedulebuilder.dto.UserDTO;
import ua.edu.lnu.schedulebuilder.exception.EmailAlreadyTakenException;
import ua.edu.lnu.schedulebuilder.mapper.UserMapper;
import ua.edu.lnu.schedulebuilder.model.Role;
import ua.edu.lnu.schedulebuilder.model.User;
import ua.edu.lnu.schedulebuilder.repository.UserRepository;
import ua.edu.lnu.schedulebuilder.security.PasswordConfig;
import ua.edu.lnu.schedulebuilder.service.AuthenticationService;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String EMAIL_ALREADY_TAKEN = "Email already taken: ";

    public final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordConfig passwordConfig;

    @Override
    public AuthenticationResponseDTO register(@NotNull RegistrationRequestDTO request) {
        UserDTO userDTO =
            new UserDTO(
                request.getEmail(),
                request.getPassword(),
                Role.USER);
        User user = userMapper.dtoToEntity(userDTO);
        String encodedPassword = passwordConfig.passwordEncoder()
            .encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        boolean userExists = userRepository
            .findByEmail(userDTO.getEmail())
            .isPresent();

        if (userExists) {
            throw new EmailAlreadyTakenException(
                EMAIL_ALREADY_TAKEN + userDTO.getEmail(), userDTO);
        }
        userRepository.save(user);
        var jwtToken =
            jwtService.generateToken(userMapper.dtoToEntity(userDTO));
        return AuthenticationResponseDTO.builder()
            .token(jwtToken)
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
            .token(jwtToken)
            .build();
    }
}
