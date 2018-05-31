package com.poc.spring.service;

import java.nio.ByteBuffer;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.poc.spring.model.User;
import com.poc.spring.repository.UserRepository;
import com.poc.spring.security.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    UUID uid;
    @Transactional
    public UserDetails loadUserByUUID(String uid)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUid(uid)
               /* .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with uuid : " + uid)
        )*/;

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		
	
	return loadUserByUUID(uid);
	}
}