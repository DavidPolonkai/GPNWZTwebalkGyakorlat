package com.meiit.webalk.GPNWZT.services.domainservices;

import java.util.List;

import com.meiit.webalk.GPNWZT.User;
import com.meiit.webalk.GPNWZT.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        String raw=user.getPassword();
        user.setPassword(passwordEncoder.encode(raw));
        userRepository.save(user);
    }

	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
	}
}
