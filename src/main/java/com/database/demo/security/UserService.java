package com.database.demo.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.database.demo.repositories.UserRepository;
import com.database.demo.models.Users;

import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
    	
    		Users user = userRepository.findByUsername(userEmail);
	        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
	        LOG.info("configure UserDetails {} :", authority.getAuthority());
	        return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
    }
}
