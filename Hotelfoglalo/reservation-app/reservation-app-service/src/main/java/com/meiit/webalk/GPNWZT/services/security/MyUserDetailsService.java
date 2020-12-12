package com.meiit.webalk.GPNWZT.services.security;

import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return  new MyUserPrincipal(user);
        // rg.springframework.security.core.userdetails.User.builder().username(email)
        // .password(bCryptPasswordEncoder.encode(user.getPassword())).disabled(false).accountExpired(false).accountLocked(false)
        // .credentialsExpired(false).roles("USER").build();
    }
}
