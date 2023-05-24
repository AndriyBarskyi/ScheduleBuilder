package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.model.User;
import ua.edu.lnu.schedulebuilder.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG =
        "Incorrect user ID or password. Try again";
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
        throws UsernameNotFoundException {

        User user = userRepository
            .findByEmail(email)
            .orElseThrow(() -> new InternalAuthenticationServiceException(
                USER_NOT_FOUND_MSG));

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .authorities(String.valueOf(user.getRole()))
            .build();
    }
}
