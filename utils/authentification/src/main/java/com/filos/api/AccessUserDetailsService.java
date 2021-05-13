package com.filos.api;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.filos.dto.UserDto;
import com.filos.utils.AccountUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccessUserDetailsService implements UserDetailsService{
    private final AbstractUserDetailsRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDto user = userRepository.findByUsername(login)
                                     .orElseThrow(() -> new UsernameNotFoundException("User not found with login" + login));
        return new User(user.username(),
                        user.password(),
                        user.enabled(),
                        AccountUtils.accountExpired(user.lastAccess()),
                        AccountUtils.accountExpired(user.lastUpdatePassword()),
                        user.locked(),
                        List.of());
    }

}
